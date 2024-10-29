package lg.pg.aui.cmd;

import lg.pg.aui.appointment.entity.Appointment;
import lg.pg.aui.appointment.entity.Doctor;
import lg.pg.aui.appointment.service.impl.AppointmentDefaultService;
import lg.pg.aui.appointment.service.impl.DoctorDefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private AppointmentDefaultService appointmentDefaultService;

    @Autowired
    private DoctorDefaultService doctorDefaultService;

    private final Scanner scanner = new Scanner(System.in);


    @Override
    public void run(String... args) throws Exception {
        boolean running = true;
        printMenu();

        while (running) {
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "help":
                    printCommands();
                    break;
                case "print doctors":
                    printDoctors();
                    break;
                case "print appointments":
                    printAppointments();
                    break;
                case "add doctor":
                    addDoctor();
                    break;
                case "delete doctor":
                    deleteDoctor();
                    break;
                case "add appointment":
                    addAppointment();
                    break;
                case "delete appointment":
                    deleteAppointment();
                    break;
                case "search appointment":
                    searchAppointment();
                    break;
                case "search doctor":
                    searchDoctor();
                    break;
                case "exit":
                    running = false;
                    System.out.println("Application stopped.");
                    break;
                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Local clinic appointment system. Type 'help' to list all available commands.");
    }

    public static void printCommands() {
        System.out.println("Available commands: ");
        System.out.println("help - list all available commands");
        System.out.println("print doctors - list all doctors with their details");
        System.out.println("print appointments - list all appointments with details");
        System.out.println("add doctor - add new doctor");
        System.out.println("delete doctor - delete existing doctor");
        System.out.println("add appointment - add new appointment");
        System.out.println("delete appointment - delete existing appointment");
        System.out.println("search appointment - search for an appointment");
        System.out.println("search doctor - search for a doctor");
        System.out.println("exit - stop the application");
    }

    public void printDoctors() {
        doctorDefaultService.findAll().forEach(System.out::println);
    }

    public void printAppointments() {
        appointmentDefaultService.findAll().forEach(System.out::println);
    }

    public void addDoctor() {
        System.out.println("Enter doctor's full name: ");
        String fullName = scanner.nextLine().trim();
        System.out.println("Enter doctor's specialization: ");
        String specialization = scanner.nextLine().trim();
        try {
            doctorDefaultService.create(Doctor.builder()
                    .id(UUID.randomUUID())
                    .fullName(fullName)
                    .specialization(specialization)
                    .appointments(new ArrayList<>())
                    .build());
        } catch (Exception e) {
            System.out.println("Error occurred while adding doctor: " + e.getMessage());
        }
        System.out.println("Doctor added successfully.");
    }

    public void deleteDoctor(){
        System.out.println("Available doctors: ");
        doctorDefaultService.findAll().forEach(doctor ->
            System.out.println(doctor.getId() + ": " + doctor.getFullName() + " (" + doctor.getSpecialization() + ")")
        );

        System.out.println("Enter doctor's ID to delete: ");
        String id = scanner.nextLine().trim();
        try {
            doctorDefaultService.delete(UUID.fromString(id));
        } catch (Exception e) {
            System.out.println("Error occurred while deleting doctor: " + e.getMessage());
            return;
        }
        System.out.println("Doctor deleted successfully.");
    }

    public void addAppointment() {
        System.out.println("Enter patient's name: ");
        String patientName = scanner.nextLine().trim();

        System.out.println("Enter patient's age: ");
        int patientAge = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Available doctors: ");
        doctorDefaultService.findAll().forEach(doctor ->
            System.out.println(doctor.getId() + ": " + doctor.getFullName() + " (" + doctor.getSpecialization() + ")")
        );

        System.out.println("Enter doctor's ID: ");
        UUID doctorId = UUID.fromString(scanner.nextLine().trim());

        Doctor assignedDoctor = doctorDefaultService.findAll().stream()
            .filter(doctor -> doctor.getId().equals(doctorId))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Invalid doctor ID"));

        try {
            appointmentDefaultService.create(Appointment.builder()
                .id(UUID.randomUUID())
                .patientName(patientName)
                .patientAge(patientAge)
                .assignedDoctor(assignedDoctor)
                .build());
        } catch (Exception e) {
            System.out.println("Error occurred while adding appointment: " + e.getMessage());
            return;
        }
        System.out.println("Appointment added successfully.");
    }

    public void deleteAppointment() {
        System.out.println("Available appointments: ");
        appointmentDefaultService.findAll().forEach(appointment ->
            System.out.println(appointment.getId() + ": " + appointment.getPatientName() + " (" + appointment.getAssignedDoctor().getFullName() + ")")
        );

        System.out.println("Enter appointment ID: ");
        String id = scanner.nextLine().trim();
        try {
            appointmentDefaultService.delete(UUID.fromString(id));
            System.out.println("Appointment deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error occurred while deleting appointment: " + e.getMessage());
        }
    }

    public void searchAppointment() {
        System.out.println("Patients' names: ");
        appointmentDefaultService.findAll().forEach(appointment -> System.out.println(appointment.getPatientName()));
        System.out.println("Enter patient's name: ");
        String patientName = scanner.nextLine().trim();
        appointmentDefaultService.findByPatientName(patientName).forEach(System.out::println);
        System.out.println("finished.");
    }

    public void searchDoctor() {
        System.out.println("Enter doctor's specialization: ");
        String specialization = scanner.nextLine().trim();

        doctorDefaultService.findBySpecialization(specialization).forEach(System.out::println);
        System.out.println("finished.");
    }

}

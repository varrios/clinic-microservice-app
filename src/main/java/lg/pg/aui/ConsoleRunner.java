package lg.pg.aui;

import lg.pg.aui.businessData.Appointment;
import lg.pg.aui.businessData.Doctor;
import lg.pg.aui.service.AppointmentService;
import lg.pg.aui.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorService doctorService;

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
        System.out.println("exit - stop the application");
    }

    public void printDoctors() {
        doctorService.findAll().forEach(System.out::println);
    }

    public void printAppointments() {
        appointmentService.findAll().forEach(System.out::println);
    }

    public void addDoctor() {
        System.out.println("Enter doctor's full name: ");
        String fullName = scanner.nextLine().trim();
        System.out.println("Enter doctor's specialization: ");
        String specialization = scanner.nextLine().trim();
        try {
            doctorService.create(Doctor.builder()
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
        System.out.println("Enter doctor's ID: ");
        String id = scanner.nextLine().trim();
        try {
            doctorService.delete(UUID.fromString(id));
        } catch (Exception e) {
            System.out.println("Error occurred while deleting doctor: " + e.getMessage());
        }
        System.out.println("Doctor deleted successfully.");
    }

    public void addAppointment() {
        System.out.println("Enter patient's name: ");
        String patientName = scanner.nextLine().trim();

        System.out.println("Enter patient's age: ");
        int patientAge = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Available doctors: ");
        doctorService.findAll().forEach(doctor ->
            System.out.println(doctor.getId() + ": " + doctor.getFullName() + " (" + doctor.getSpecialization() + ")")
        );

        System.out.println("Enter doctor's ID: ");
        UUID doctorId = UUID.fromString(scanner.nextLine().trim());

        Doctor assignedDoctor = doctorService.findAll().stream()
            .filter(doctor -> doctor.getId().equals(doctorId))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Invalid doctor ID"));

        try {
            appointmentService.create(Appointment.builder()
                .id(UUID.randomUUID())
                .patientName(patientName)
                .patientAge(patientAge)
                .assignedDoctor(assignedDoctor)
                .build());
        } catch (Exception e) {
            System.out.println("Error occurred while adding appointment: " + e.getMessage());
        }
        System.out.println("Appointment added successfully.");
    }

    public void deleteAppointment() {
        System.out.println("Enter appointment ID: ");
        String id = scanner.nextLine().trim();
        try {
            appointmentService.delete(UUID.fromString(id));
            System.out.println("Appointment deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error occurred while deleting appointment: " + e.getMessage());
        }
    }
}

package lg.pg.aui.appointment.service.impl;

import lg.pg.aui.appointment.entity.Appointment;
import lg.pg.aui.appointment.entity.Doctor;
import lg.pg.aui.appointment.repository.api.AppointmentRepository;
import lg.pg.aui.appointment.service.api.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentDefaultService implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentDefaultService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findByAssignedDoctor(Doctor assignedDoctor) {
        return appointmentRepository.findAppointmentsByAssignedDoctor(assignedDoctor);
    }

    public List<Appointment> findByPatientName(String patientName) {
        return appointmentRepository.findAppointmentByPatientName(patientName);
    }

    public void create(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public void delete(UUID uuid) {
        appointmentRepository.deleteById(uuid);
    }
}
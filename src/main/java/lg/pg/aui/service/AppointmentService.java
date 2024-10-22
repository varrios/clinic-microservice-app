package lg.pg.aui.service;

import lg.pg.aui.entities.Appointment;
import lg.pg.aui.entities.Doctor;
import lg.pg.aui.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
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

    public void create(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public void delete(UUID uuid) {
        appointmentRepository.deleteById(uuid);
    }
}
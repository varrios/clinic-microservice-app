package lg.pg.aui.appointment.service.api;

import lg.pg.aui.appointment.entity.Appointment;
import lg.pg.aui.appointment.entity.Doctor;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {

    List<Appointment> findAll();

    Appointment save(Appointment appointment);

    List<Appointment> findByAssignedDoctor(Doctor assignedDoctor);

    List<Appointment> findByPatientName(String patientName);

    void create(Appointment appointment);

    void delete(UUID uuid);
}

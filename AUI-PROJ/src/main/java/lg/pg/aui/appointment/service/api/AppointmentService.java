package lg.pg.aui.appointment.service.api;

import lg.pg.aui.appointment.entity.Appointment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentService {

    Optional<Appointment> findById(UUID id);

    List<Appointment> findAll();

    Optional<List<Appointment>> findAllByAssignedDoctor(UUID assignedDoctor);

    Optional<List<Appointment>> findByPatientName(String patientName);

    void create(Appointment appointment);

    void delete(UUID uuid);

    void update(Appointment appointment);
}

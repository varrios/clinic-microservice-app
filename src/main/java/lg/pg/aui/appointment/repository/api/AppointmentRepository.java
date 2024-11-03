package lg.pg.aui.appointment.repository.api;

import lg.pg.aui.appointment.entity.Appointment;
import lg.pg.aui.appointment.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    List<Appointment> findAppointmentsByAssignedDoctor(Doctor assignedDoctor);
    List<Appointment> findAppointmentByPatientName(String patientName);
}

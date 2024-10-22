package lg.pg.aui.repository;

import lg.pg.aui.entities.Appointment;
import lg.pg.aui.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    List<Appointment> findAppointmentsByAssignedDoctor(Doctor assignedDoctor);
    List<Appointment> findAppointmentByPatientName(String patientName);
}

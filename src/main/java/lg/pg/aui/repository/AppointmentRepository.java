package lg.pg.aui.repository;

import lg.pg.aui.businessData.Appointment;
import lg.pg.aui.businessData.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    List<Appointment> findAppointmentsByAssignedDoctor(Doctor assignedDoctor);
}

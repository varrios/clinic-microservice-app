package lg.pg.aui.doctor.repository.api;

import lg.pg.aui.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
   List<Doctor> findBySpecialization(String specialization);
}
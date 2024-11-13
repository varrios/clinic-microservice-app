package lg.pg.aui.appointment.service.api;

import lg.pg.aui.appointment.entity.Doctor;
import lg.pg.aui.appointment.repository.api.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorService {

    Optional<Doctor> findById(UUID id);

    List<Doctor> findAll();

    List<Doctor> findBySpecialization(String specialization);


    void create(Doctor doctor);

    void delete(UUID id);
}

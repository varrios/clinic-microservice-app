package lg.pg.aui.doctor.service.api;

import lg.pg.aui.doctor.entity.Doctor;

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

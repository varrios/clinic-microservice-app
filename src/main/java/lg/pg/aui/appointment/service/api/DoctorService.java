package lg.pg.aui.appointment.service.api;

import lg.pg.aui.appointment.entity.Doctor;
import lg.pg.aui.appointment.repository.api.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public interface DoctorService {

    List<Doctor> findAll();

    Doctor save(Doctor doctor);

    List<Doctor> findBySpecialization(String specialization);


    void create(Doctor doctor);

    void delete(UUID id);
}

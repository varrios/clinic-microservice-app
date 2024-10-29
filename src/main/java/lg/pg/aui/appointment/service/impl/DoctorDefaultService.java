package lg.pg.aui.appointment.service.impl;

import lg.pg.aui.appointment.entity.Doctor;
import lg.pg.aui.appointment.repository.api.DoctorRepository;
import lg.pg.aui.appointment.service.api.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorDefaultService implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorDefaultService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> findAll() { return doctorRepository.findAll(); }

    public Doctor save(Doctor doctor) { return doctorRepository.save(doctor); }

    public List<Doctor> findBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }


    public void create(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public void delete(UUID id) {
        doctorRepository.deleteById(id);
    }
}

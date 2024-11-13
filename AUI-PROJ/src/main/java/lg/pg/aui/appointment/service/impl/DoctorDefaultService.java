package lg.pg.aui.appointment.service.impl;

import lg.pg.aui.appointment.entity.Doctor;
import lg.pg.aui.appointment.repository.api.DoctorRepository;
import lg.pg.aui.appointment.service.api.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorDefaultService implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorDefaultService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> findAll() { return doctorRepository.findAll(); }

    @Override
    public List<Doctor> findBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

    @Override
    public Optional<Doctor> findById(UUID id) {
        return doctorRepository.findById(id);
    }

    @Override
    public void create(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void delete(UUID id) {
        doctorRepository.deleteById(id);
    }
}

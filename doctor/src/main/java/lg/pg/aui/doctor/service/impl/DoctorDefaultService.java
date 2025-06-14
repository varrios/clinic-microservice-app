package lg.pg.aui.doctor.service.impl;

import lg.pg.aui.doctor.entity.Doctor;
import lg.pg.aui.doctor.event.repository.api.DoctorEventRepository;
import lg.pg.aui.doctor.repository.api.DoctorRepository;
import lg.pg.aui.doctor.service.api.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorDefaultService implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorEventRepository eventRepository;

    @Autowired
    public DoctorDefaultService(DoctorRepository doctorRepository, DoctorEventRepository eventRepository) {

        this.doctorRepository = doctorRepository;
        this.eventRepository = eventRepository;
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
//        if (eventRepository != null) {
//            eventRepository.save(doctor);
//        }
//        else{
//            System.out.println("Event repository is null");
//        }
    }

    @Override
    public void delete(UUID id) {
        doctorRepository.findById(id).ifPresent(doctorRepository::delete);
        if (eventRepository != null){
            eventRepository.delete(id);
        }else{
            System.out.println("Event repository is null");
        }

    }
}

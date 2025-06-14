package lg.pg.aui.doctor.event.repository.rest;

import lg.pg.aui.doctor.entity.Doctor;
import lg.pg.aui.doctor.event.repository.api.DoctorEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class DoctorEventRestRepository implements DoctorEventRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public DoctorEventRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/doctors/{id}", id);
    }

    @Override
    public void save(Doctor doctor) {
        restTemplate.put("/api/doctor/{id}", doctor, doctor.getId());
    }
}

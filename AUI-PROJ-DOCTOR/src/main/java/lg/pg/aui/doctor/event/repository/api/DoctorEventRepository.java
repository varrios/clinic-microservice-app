package lg.pg.aui.doctor.event.repository.api;
import lg.pg.aui.doctor.entity.Doctor;

import java.util.UUID;



public interface DoctorEventRepository {
    void delete(UUID id);

    void save(Doctor doctor);
}

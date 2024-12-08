package lg.pg.aui.doctor.function;

import lg.pg.aui.doctor.dto.PutDoctorRequest;
import lg.pg.aui.doctor.entity.Doctor;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.UUID;
import java.util.function.BiFunction;

/**
 * Converts {@link lg.pg.aui.doctor.dto.PutDoctorRequest} to {@link lg.pg.aui.doctor.entity.Doctor}. Caution, some fields are not set as they should be updated
 * by business logic.
 */
@Component
public class RequestToDoctorFunction implements BiFunction<UUID, PutDoctorRequest, Doctor> {

    @Override
    public Doctor apply(UUID id, PutDoctorRequest request) {
        return Doctor.builder()
                .id(id)
                .fullName(request.getFullName())
                .specialization(request.getSpecialization())
                .build();
    }

}
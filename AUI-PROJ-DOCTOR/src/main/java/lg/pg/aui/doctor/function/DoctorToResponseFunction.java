package lg.pg.aui.doctor.function;


import lg.pg.aui.doctor.dto.GetDoctorResponse;
import lg.pg.aui.doctor.entity.Doctor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Converts {@link Doctor} to {@link lg.pg.aui.doctor.dto.GetDoctorResponse}.
 */
@Component
public class DoctorToResponseFunction implements Function<Doctor, GetDoctorResponse> {

    @Override
    public GetDoctorResponse apply(Doctor entity) {
        return GetDoctorResponse.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .build();
    }


}

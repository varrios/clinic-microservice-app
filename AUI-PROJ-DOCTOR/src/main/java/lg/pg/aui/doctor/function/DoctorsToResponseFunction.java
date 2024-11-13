package lg.pg.aui.doctor.function;


import lg.pg.aui.doctor.dto.GetDoctorsResponse;
import lg.pg.aui.doctor.entity.Doctor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;


/**
 * Converts {@link List<Doctor>} to {@link lg.pg.aui.doctor.dto.GetDoctorsResponse}.
 */
@Component
public class DoctorsToResponseFunction implements Function<List<Doctor>, GetDoctorsResponse>{

    @Override
    public GetDoctorsResponse apply(List<Doctor> entities) {
        return GetDoctorsResponse.builder()
                .doctors(entities.stream()
                        .map(profession -> GetDoctorsResponse.Doctor.builder()
                                .id(profession.getId())
                                .fullName(profession.getFullName())
                                .build())
                        .toList())
                .build();
    }

}

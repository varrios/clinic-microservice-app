package lg.pg.aui.appointment.function;


import lg.pg.aui.appointment.dto.GetDoctorsResponse;
import lg.pg.aui.appointment.entity.Doctor;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.List;
import java.util.function.Function;


/**
 * Converts {@link List<Doctor>} to {@link lg.pg.aui.appointment.dto.GetDoctorsResponse}.
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
                                .specialization(profession.getSpecialization())
                                .build())
                        .toList())
                .build();
    }

}

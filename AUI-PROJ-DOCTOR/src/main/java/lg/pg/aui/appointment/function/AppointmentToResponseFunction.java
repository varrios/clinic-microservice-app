package lg.pg.aui.appointment.function;

import org.springframework.stereotype.Component;
import lg.pg.aui.appointment.entity.Appointment;
import lg.pg.aui.appointment.dto.GetAppointmentResponse;

import java.util.function.Function;

/**
 * Converts {@link Appointment} to {@link GetAppointmentResponse}.
 */
@Component
public class AppointmentToResponseFunction implements Function<Appointment, GetAppointmentResponse> {

    @Override
    public GetAppointmentResponse apply(Appointment entity) {
        return GetAppointmentResponse.builder()
                .id(entity.getId())
                .patientName(entity.getPatientName())
                .patientAge(entity.getPatientAge())
                .assignedDoctor(GetAppointmentResponse.Doctor.builder()
                        .id(entity.getAssignedDoctor().getId())
                        .fullName(entity.getAssignedDoctor().getFullName())
                        .specialization(entity.getAssignedDoctor().getSpecialization())
                        .build())
                .build();
    }

}

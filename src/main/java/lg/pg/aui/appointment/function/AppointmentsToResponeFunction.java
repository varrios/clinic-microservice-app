package lg.pg.aui.appointment.function;

import org.springframework.stereotype.Component;
import lg.pg.aui.appointment.entity.Appointment;
import lg.pg.aui.appointment.dto.GetAppointmentsResponse;

import java.util.function.Function;
import java.util.List;

/**
 * Converts {@link List<Appointment>} to {@link GetAppointmentsResponse}.
 */
@Component
public class AppointmentsToResponeFunction implements Function<List<Appointment>, GetAppointmentsResponse>{

    @Override
    public GetAppointmentsResponse apply(List<Appointment> entities) {
        return GetAppointmentsResponse.builder()
                .appointments(entities.stream()
                        .map(appointment -> GetAppointmentsResponse.Appointment.builder()
                                .id(appointment.getId())
                                .patientName(appointment.getPatientName())
                                .patientAge(appointment.getPatientAge())
                                .build())
                        .toList())
                .build();
    }
}

package lg.pg.aui.appointment.function;
import lg.pg.aui.appointment.dto.PatchAppointmentRequest;
import lg.pg.aui.appointment.entity.Appointment;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

/**
 * Returns new instance of {@link Appointment} based on provided value and updated with values from
 * {@link PatchAppointmentRequest}.
 */
@Component
public class UpdateAppointmentWithRequestFunction implements BiFunction<Appointment, PatchAppointmentRequest, Appointment> {

    @Override
    public Appointment apply(Appointment entity, PatchAppointmentRequest request) {
        return Appointment.builder()
                .id(entity.getId())
                .patientName(request.getPatientName())
                .patientAge(request.getPatientAge())
                .assignedDoctor(entity.getAssignedDoctor())
                .build();
    }

}


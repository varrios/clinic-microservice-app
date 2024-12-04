package lg.pg.aui.appointment.function;

import lg.pg.aui.appointment.dto.PutAppointmentRequest;
import lg.pg.aui.appointment.entity.Appointment;
import lg.pg.aui.doctor.entity.Doctor;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

/**
 * Converts {@link lg.pg.aui.appointment.dto.PutAppointmentRequest} to {@link lg.pg.aui.appointment.entity.Appointment}. Caution, some fields are not set as they should be updated
 * by business logic.
 */
@Component
public class RequestToAppointmentFunction implements BiFunction<UUID, PutAppointmentRequest, Appointment> {

    @Override
    public Appointment apply(UUID id, PutAppointmentRequest request) {
        return Appointment.builder()
                .id(id)
                .patientName(request.getPatientName())
                .patientAge(request.getPatientAge())
                .assignedDoctor(Doctor.builder()
                        .id(request.getDoctorId())
                        .build())
                .build();
    }

}


package lg.pg.aui.appointment.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * PUT appointment request. Contains all fields that can be set up by the user. How appointment is described is defined
 * in {@link GetAppointmentsResponse.Appointment} and {@link lg.pg.aui.appointment.entity.Appointment} classes.
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutAppointmentRequest {

        private String patientName;
        private int patientAge;
        private UUID doctorId;
}

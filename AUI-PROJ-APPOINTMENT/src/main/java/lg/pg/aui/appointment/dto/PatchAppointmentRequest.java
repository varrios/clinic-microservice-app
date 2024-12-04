package lg.pg.aui.appointment.dto;

import lg.pg.aui.appointment.entity.Appointment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * PATCH appointment request. Contains all fields that can be updated by the user. How appointment is described is defined
 * in {@link GetAppointmentsResponse.Appointment} and {@link Appointment} classes.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class PatchAppointmentRequest {

    private String patientName;
    private int patientAge;
}

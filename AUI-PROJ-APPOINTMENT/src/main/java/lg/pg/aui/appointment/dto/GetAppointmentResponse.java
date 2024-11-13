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
 * GET appointment response. It contains all field that can be presented (but not necessarily changed) to the used. How
 * appointment is described is defined in {@link GetAppointmentsResponse.Appointment}
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetAppointmentResponse {
    /**
     * Represents single doctor.
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Doctor {

        /**
         * Unique id identifying doctor.
         */
        private UUID id;

        /**
         * Full name of the doctor.
         */
        private String fullName;

        /**
         * Specialization of the doctor.
         */
        private String specialization;
    }

    private UUID id;
    private String patientName;
    private int patientAge;
    private Doctor assignedDoctor;


}

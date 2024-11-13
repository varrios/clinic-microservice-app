package lg.pg.aui.appointment.dto;

import lombok.*;

import java.util.UUID;
import java.util.List;


/**
 * GET appointments response. Contains list of available appointments. Can be used to list all appointments.
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetAppointmentsResponse {

    /**
     * Represents single appointment.
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Appointment {

        /**
         * Unique id identifying appointment.
         */
        private UUID id;

        /**
         * Name of the patient.
         */
        private String patientName;

        /**
         * Age of the patient.
         */
        private int patientAge;
    }

    /**
     * Name of the selected appointments.
     */
    @Singular
    private List<Appointment> appointments;
}

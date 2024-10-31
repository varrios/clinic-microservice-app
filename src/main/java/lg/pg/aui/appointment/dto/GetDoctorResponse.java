package lg.pg.aui.appointment.dto;

import lg.pg.aui.appointment.entity.Doctor;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

import java.util.Map;
import java.util.UUID;




/**
 * GET doctor response. Described details about selected doctor.
 * How doctor is described is defined in
 * {@link Doctor}.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetDoctorResponse {

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

    private UUID id;
    private String fullName;
    private String specialization;

    @Singular
    private Map<Integer, Appointment> appointments;



}

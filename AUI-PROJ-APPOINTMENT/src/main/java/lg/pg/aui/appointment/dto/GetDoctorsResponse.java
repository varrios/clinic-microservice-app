package lg.pg.aui.appointment.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;



/**
 * GET doctors response. Returns list of all doctors.
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetDoctorsResponse {

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

    /**
     * List of all doctors.
     */
    private List<Doctor> doctors;
}

package lg.pg.aui.doctor.dto;


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
 * in {@link GetDoctorsResponse.Doctor} and {@link lg.pg.aui.doctor.entity.Doctor} classes.
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutDoctorRequest {

        private String specialization;
        private String fullName;

}
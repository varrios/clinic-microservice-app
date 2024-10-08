package lg.pg.aui;

import lombok.*;

@Getter
@Setter
@Builder
public class PatientDto {

    private String patientName;
    private int patientAge;
    private String assignedDoctorSpecialization;

    @Override
    public String toString() {
        return "Appointment - " + patientName + "\n" +
                "Age: " + patientAge + "\n" +
                "Assigned doctor specialization: " + assignedDoctorSpecialization + "\n";
    }
}

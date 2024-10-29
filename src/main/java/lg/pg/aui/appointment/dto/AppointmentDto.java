package lg.pg.aui.appointment.dto;

import lombok.*;

@Getter
@Setter
@Builder
public class AppointmentDto {

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

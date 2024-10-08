package lg.pg.aui;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@EqualsAndHashCode(exclude = "assignedDoctor")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)

@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "patient_name", nullable = false)
    private String patientName;

    @Column(name = "patient_age", nullable = false)
    private int patientAge;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor assignedDoctor;

    @Override
    public String toString() {
        return "Appointment - " + patientName + "\n" +
                "Age: " + patientAge + "\n";
    }


}

package lg.pg.aui.appointment.entity;

import jakarta.persistence.*;
import lg.pg.aui.doctor.entity.Doctor;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@EqualsAndHashCode(exclude = "assignedDoctor")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {

    @Id
    @Column(name = "appointment_id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "patient_name", nullable = false)
    private String patientName;

    @Column(name = "patient_age", nullable = false)
    private int patientAge;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    @ToString.Exclude
    private Doctor assignedDoctor;

}

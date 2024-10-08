package lg.pg.aui;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Builder
@EqualsAndHashCode(exclude = "appointments")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)

@Entity
@Table(name = "doctors")
public class Doctor implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments;


    @Override
    public String toString() {
        return "Doctor - " + name + "\n" +
                "Specialization: " + specialization + "\n";
    }


}

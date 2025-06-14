package lg.pg.aui.appointment.initialize;

import lg.pg.aui.appointment.entity.Appointment;
import lg.pg.aui.doctor.entity.Doctor;
import lg.pg.aui.appointment.service.impl.AppointmentDefaultService;
import lg.pg.aui.doctor.service.impl.DoctorDefaultService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    private final DoctorDefaultService doctorDefaultService;

    private final AppointmentDefaultService appointmentDefaultService;

    @Autowired
    public InitializeData(
            DoctorDefaultService doctorDefaultService,
            AppointmentDefaultService appointmentDefaultService
    ) {
        this.doctorDefaultService = doctorDefaultService;
        this.appointmentDefaultService = appointmentDefaultService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Doctor surgeonDoctor = Doctor.builder()
                .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                .fullName("Jan Kowalski")
                .specialization("Surgeon")
                .appointments(new ArrayList<>())
                .build();

        Doctor psychiatristDoctor = Doctor.builder()
                .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                .fullName("Tomasz Nowak")
                .specialization("Psychiatrist")
                .appointments(new ArrayList<>())
                .build();

        Doctor pediatricianDoctor = Doctor.builder()
                .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                .fullName("Anna Wiśniewska")
                .specialization("Pediatrician")
                .appointments(new ArrayList<>())
                .build();
        doctorDefaultService.create(surgeonDoctor);
        doctorDefaultService.create(psychiatristDoctor);
        doctorDefaultService.create(pediatricianDoctor);

        Appointment appointment1 = Appointment.builder()
                .id(UUID.randomUUID())
                .patientName("Marek Nowak")
                .patientAge(24)
                .assignedDoctor(psychiatristDoctor)
                .build();

        Appointment appointment2 = Appointment.builder()
                .id(UUID.randomUUID())
                .patientName("Andrzej Kamiński")
                .patientAge(15)
                .assignedDoctor(pediatricianDoctor)
                .build();

        Appointment appointment3 = Appointment.builder()
                .id(UUID.randomUUID())
                .patientName("Jakub Mazur")
                .patientAge(48)
                .assignedDoctor(surgeonDoctor)
                .build();

        Appointment appointment4 = Appointment.builder()
                .id(UUID.randomUUID())
                .patientName("Zofia Mazur")
                .patientAge(78)
                .assignedDoctor(surgeonDoctor)
                .build();

        appointmentDefaultService.create(appointment1);
        appointmentDefaultService.create(appointment2);
        appointmentDefaultService.create(appointment3);
        appointmentDefaultService.create(appointment4);
    }

    @SneakyThrows
    private byte[] getResourceAsByteArray(String name) {
        try (InputStream is = this.getClass().getResourceAsStream(name)) {
            assert is != null;
            return is.readAllBytes();
        }
    }

}

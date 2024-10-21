package lg.pg.aui.initialize;

import lg.pg.aui.businessData.Appointment;
import lg.pg.aui.businessData.Doctor;
import lg.pg.aui.service.AppointmentService;
import lg.pg.aui.service.DoctorService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    private final DoctorService doctorService;

    private final AppointmentService appointmentService;

    @Autowired
    public InitializeData(
            DoctorService doctorService,
            AppointmentService appointmentService
    ) {
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Doctor surgeonDoctor = Doctor.builder()
                .id(UUID.randomUUID())
                .fullName("Jan Kowalski")
                .specialization("Surgeon")
                .appointments(new ArrayList<>())
                .build();

        Doctor psychiatristDoctor = Doctor.builder()
                .id(UUID.randomUUID())
                .fullName("Tomasz Nowak")
                .specialization("Psychiatrist")
                .appointments(new ArrayList<>())
                .build();

        Doctor pediatricianDoctor = Doctor.builder()
                .id(UUID.randomUUID())
                .fullName("Anna Wiśniewska")
                .specialization("Pediatrician")
                .appointments(new ArrayList<>())
                .build();
        doctorService.create(surgeonDoctor);
        doctorService.create(psychiatristDoctor);
        doctorService.create(pediatricianDoctor);

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

        appointmentService.create(appointment1);
        appointmentService.create(appointment2);
        appointmentService.create(appointment3);
        appointmentService.create(appointment4);
    }

    @SneakyThrows
    private byte[] getResourceAsByteArray(String name) {
        try (InputStream is = this.getClass().getResourceAsStream(name)) {
            assert is != null;
            return is.readAllBytes();
        }
    }

}

package lg.pg.aui.doctor.initialize;

import lg.pg.aui.doctor.entity.Doctor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lg.pg.aui.doctor.service.api.DoctorService;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    private final DoctorService doctorService;

    @Autowired
    public InitializeData(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @Override
    public void afterPropertiesSet() throws Exception{
        if(doctorService.findAll().isEmpty()){
            Doctor doctor1 = Doctor.builder()
                .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                .fullName("Marek Kowalski")
                .specialization("Dentist")
                .build();
            Doctor doctor2 = Doctor.builder()
                .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                .fullName("Jan Nowak")
                .specialization("Pediatrician")
                .build();
            Doctor doctor3 = Doctor.builder()
                .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                .fullName("Tomek Marczewski")
                .specialization("Surgeon")
                .build();
            doctorService.create(doctor1);
            doctorService.create(doctor2);
            doctorService.create(doctor3);
        }

    }
}

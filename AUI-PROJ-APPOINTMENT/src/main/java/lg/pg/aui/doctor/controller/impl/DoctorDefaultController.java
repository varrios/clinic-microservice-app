package lg.pg.aui.doctor.controller.impl;

import lg.pg.aui.doctor.controller.api.DoctorController;
import lg.pg.aui.appointment.dto.GetDoctorResponse;
import lg.pg.aui.appointment.dto.GetDoctorsResponse;
import lg.pg.aui.appointment.function.DoctorToResponseFunction;
import lg.pg.aui.appointment.function.DoctorsToResponseFunction;
import lg.pg.aui.doctor.service.api.DoctorService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class DoctorDefaultController implements DoctorController {

    private final DoctorService service;
    private final DoctorToResponseFunction doctorToResponse;
    private final DoctorsToResponseFunction doctorsToResponse;

    public DoctorDefaultController(DoctorService service, DoctorToResponseFunction doctorToResponse, DoctorsToResponseFunction doctorsToResponse) {
        this.service = service;
        this.doctorToResponse = doctorToResponse;
        this.doctorsToResponse = doctorsToResponse;
    }

    @Override
    public GetDoctorsResponse getDoctors() {
        return doctorsToResponse.apply(service.findAll());
    }

    @Override
    public GetDoctorResponse getDoctor(UUID id) {
        return service.findById(id)
                .map(doctorToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteDoctor(UUID id) {
        service.findById(id)
                .ifPresentOrElse(
                        profession -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }


}

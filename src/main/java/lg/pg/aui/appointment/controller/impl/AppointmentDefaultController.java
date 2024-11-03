package lg.pg.aui.appointment.controller.impl;

import lg.pg.aui.appointment.controller.api.AppointmentController;
import lg.pg.aui.appointment.dto.GetAppointmentResponse;
import lg.pg.aui.appointment.dto.GetAppointmentsResponse;
import lg.pg.aui.appointment.dto.PutAppointmentRequest;
import lg.pg.aui.appointment.function.*;
import lg.pg.aui.appointment.service.api.AppointmentService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class AppointmentDefaultController implements AppointmentController {


    private final AppointmentService service;
    private final AppointmentToResponseFunction appointmentToResponse;
    private final AppointmentsToResponeFunction appointmentsToResponse;
    private final RequestToAppointmentFunction requestToAppointment;

    @Autowired
    public AppointmentDefaultController(
            AppointmentService appointmentService,
            AppointmentToResponseFunction appointmentToResponse,
            AppointmentsToResponeFunction appointmentsToResponse,
            RequestToAppointmentFunction requestToAppointment
    ) {
        this.service = appointmentService;
        this.appointmentToResponse = appointmentToResponse;
        this.appointmentsToResponse = appointmentsToResponse;
        this.requestToAppointment = requestToAppointment;
    }

    @Override
    public GetAppointmentsResponse getAppointments() {
        return appointmentsToResponse.apply(service.findAll());
    }

    @Override
    public GetAppointmentsResponse getDoctorAppointments(UUID id) {
        return service.findAllByAssignedDoctor(id)
                .map(appointmentsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetAppointmentResponse getAppointment(UUID id) {
        return service.findById(id)
                .map(appointmentToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putAppointment(UUID id, PutAppointmentRequest request) {
        service.create(requestToAppointment.apply(id, request));
    }

    @Override
    public void deleteAppointment(UUID id) {
        service.findById(id)
                .ifPresentOrElse(
                        appointment -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }


}

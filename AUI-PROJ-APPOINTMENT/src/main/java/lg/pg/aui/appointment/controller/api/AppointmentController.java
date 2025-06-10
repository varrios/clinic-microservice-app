package lg.pg.aui.appointment.controller.api;

import lg.pg.aui.appointment.dto.GetAppointmentResponse;
import lg.pg.aui.appointment.dto.GetAppointmentsResponse;
import lg.pg.aui.appointment.dto.PatchAppointmentRequest;
import lg.pg.aui.appointment.dto.PutAppointmentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


/**
 * Controller for appointments resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */

public interface AppointmentController {

     /**
     * @return list of all appointments
     */
    @GetMapping("api/appointments")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAppointmentsResponse getAppointments();

    /**
     * @param doctorId appointments' doctor
     * @return list of appointments assigned to doctor
     */

    @GetMapping("/api/doctors/{doctorId}/appointments")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAppointmentsResponse getDoctorAppointments(
            @PathVariable("doctorId")
            UUID doctorId
    );

    /**
     * @param id appointment's id
     * @return single appointment
     */
    @GetMapping("/api/appointments/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAppointmentResponse getAppointment(
            @PathVariable("id")
            UUID id
    );

     /**
     * @param id      appointment's id
     * @param request new appointment
     */
    @PutMapping("/api/appointments/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putAppointment(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutAppointmentRequest request
    );

    /**
     * Deletes selected appointment.
     *
     * @param id appointment's id
     */
    @DeleteMapping("/api/appointments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAppointment(
            @PathVariable("id")
            UUID id
    );

}

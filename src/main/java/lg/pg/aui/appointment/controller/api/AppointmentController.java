package lg.pg.aui.appointment.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


public interface AppointmentController {

     /**
     * request to create new appointment
     * @return list of appointments
     */

    @GetMapping("api/appointments")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAppointmentsResponse getAppointments();

    /**
     * @param userId user's id
     * @return list of user's appointments
     */
    @GetMapping("/api/users/{userId}/appointments")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAppointmentsResponse getUserAppointments(
            @PathVariable("userId")
            UUID userId
    );

    /**
     * @param doctorId doctor's id
     * @return list of doctor's appointments
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
     * @param userId user's id
     * @param appointmentId appointment's id
     * @return single appointment
     */
    @GetMapping("/api/users/{userId}/appointments/{appointmentId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCharacterResponse getUserAppointment(
            @PathVariable("userId")
            UUID userId,
            @PathVariable("appointmentId")
            UUID appointmentId
    );

    /**
     * @param id appointment's id
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


    @DeleteMapping("/api/appointments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAppointment(
            @PathVariable("id")
            UUID id
    );

}

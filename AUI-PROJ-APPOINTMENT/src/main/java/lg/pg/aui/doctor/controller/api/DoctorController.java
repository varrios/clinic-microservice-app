package lg.pg.aui.doctor.controller.api;

import lg.pg.aui.appointment.dto.GetDoctorResponse;
import lg.pg.aui.appointment.dto.GetDoctorsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;




/**
 * Controller for doctor resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
public interface DoctorController {

    /**
     * @return list of doctors
     */
    @GetMapping("api/doctors")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetDoctorsResponse getDoctors();

    /**
     * @param id doctor's id
     * @return single doctor
     */
    @GetMapping("/api/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetDoctorResponse getDoctor(
            @PathVariable("id")
            UUID id
    );

     /**
     * Deletes selected doctor.
     *
     * @param id doctor's id
     */
    @DeleteMapping("/api/doctors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDoctor(
            @PathVariable("id")
            UUID id
    );



}

package lg.pg.aui.appointment.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;



public interface DoctorController {


    /**
     * @return list of professions
     */
    @GetMapping("api/professions")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProfessionsResponse getProfessions();

    /**
     * @param id profession's id
     * @return single profession
     */
    @GetMapping("/api/professions/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProfessionResponse getProfession(
            @PathVariable("id")
            UUID id
    );


    /**
     * Deletes selected profession.
     *
     * @param id profession's id
     */
    @DeleteMapping("/api/professions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProfession(
            @PathVariable("id")
            UUID id
    );


}

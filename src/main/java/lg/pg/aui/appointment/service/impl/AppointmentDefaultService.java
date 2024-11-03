package lg.pg.aui.appointment.service.impl;

import lg.pg.aui.appointment.entity.Appointment;
import lg.pg.aui.appointment.repository.api.AppointmentRepository;
import lg.pg.aui.appointment.repository.api.DoctorRepository;
import lg.pg.aui.appointment.service.api.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentDefaultService implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;


    @Autowired
    public AppointmentDefaultService(
            AppointmentRepository appointmentRepository,
            DoctorRepository doctorRepository
    )
    {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Optional<Appointment> findById(UUID id) {
        return appointmentRepository.findById(id);
    }


    @Override
    public List<Appointment> findAll() {
        return Optional.of(appointmentRepository.findAll());
    }

    @Override
    public Optional<List<Appointment>> findAllByAssignedDoctor(UUID id) {
        if (doctorRepository.findById(id).isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(appointmentRepository.findAppointmentsByAssignedDoctor(doctorRepository.findById(id).get()));
    }

    @Override
    public Optional<List<Appointment>> findByPatientName(String patientName) {
        return Optional.ofNullable(appointmentRepository.findAppointmentByPatientName(patientName));
    }

    @Override
    public void create(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void delete(UUID uuid) {
        appointmentRepository.deleteById(uuid);
    }

    @Override
    public void update(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
import { Component } from '@angular/core';
import { AppointmentForm } from '../../model/appointment-form';
import { Doctors } from '../../model/doctors';
import { AppointmentService } from '../../service/appointment.service';
import { DoctorService } from '../../service/doctor.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Appointments } from '../../model/appointments';


@Component({
  selector: 'app-appointment-edit',
  imports: [],
  templateUrl: './appointment-edit.component.html',
  styleUrl: './appointment-edit.component.css'
})
export class AppointmentEditComponent implements OnInit {
  
  /**
   * Appointment's id.
   */
  uuid: string | undefined;

  /**
   * Single appointment.
   */
  appointment: AppointmentForm | undefined;

  /**
   * Single appointment.
   */
  original: AppointmentForm | undefined;

  /**
   * Available professions.
   */
  doctors: Doctors | undefined;

  constructor(
    private appointmentService: AppointmentService,
    private doctorService: DoctorService,
    private route: ActivatedRoute,
    private router: Router,
  ){
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.appointmentService.getAppointments()
        .subscribe(doctors => this.doctors = doctors);

      this.appointmentService.getAppointment(params['uuid'])
        .subscribe(appointment => {
          this.uuid = appointment.id;
          this.appointment = {
            patientName: appointment.patientName,
            patientAge: appointment.patientAge,
            assignedDoctor: appointment.assignedDoctor.id
          };
          this.original = {...this.appointment};
        });
    });
  }

  /**
   * Updates appointment.
   */
  onSubmit(): void {
    this.appointmentService.putAppointment(this.uuid!, this.appointment!)
      .subscribe(() => this.router.navigate(['/appointments']));
  }


}

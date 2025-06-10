import {Component, OnInit} from '@angular/core';
import {AppointmentForm} from '../../model/appointment-form';
import {AppointmentService} from '../../service/appointment.service';
import {DoctorService} from '../../../doctor/service/doctor.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {Doctors} from '../../../doctor/model/doctors';
import {NgForOf, NgIf} from '@angular/common';

@Component({
  selector: 'app-appointment-edit',
  templateUrl: './appointment-edit.component.html',
  imports: [
    FormsModule, NgIf, NgForOf
  ],
  standalone: true,
  styleUrl: './appointment-edit.component.css'
})
export class AppointmentEditComponent implements OnInit{

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
   * Available doctors.
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
      this.doctorService.getDoctors()
        .subscribe(doctors => this.doctors = doctors);

      this.appointmentService.getAppointment(params['uuid'])
        .subscribe(appointment => {
          this.uuid = appointment.id;
          this.appointment = {
            patientName: appointment.patientName,
            patientAge: appointment.patientAge,
            doctorId: appointment.assignedDoctor.id
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

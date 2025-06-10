import { Component, OnInit } from '@angular/core';
import { AppointmentForm } from '../../model/appointment-form';
import { AppointmentService } from '../../service/appointment.service';
import { DoctorService } from '../../../doctor/service/doctor.service';
import { Router } from '@angular/router';
import { Doctors } from '../../../doctor/model/doctors';
import {FormsModule} from '@angular/forms';
import {NgForOf, NgIf} from '@angular/common';
import { v4 as uuidv4 } from 'uuid';

@Component({
  selector: 'app-appointment-create',
  templateUrl: './appointment-create.component.html',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf,
    NgIf
  ],
  styleUrls: ['./appointment-create.component.css']
})
export class AppointmentCreateComponent implements OnInit {

    /**
     * Single appointment (for form binding).
     */
    id: string = uuidv4();

    appointment: AppointmentForm = {
        patientName: '',
        patientAge: 0,
        doctorId: '',
    };

    /**
     * Available doctors.
     */
    doctors: Doctors | undefined;

    constructor(
        private appointmentService: AppointmentService,
        private doctorService: DoctorService,
        private router: Router
    ) { }

    ngOnInit(): void {
        this.doctorService.getDoctors().subscribe(doctors => this.doctors = doctors);
    }

    /**
     * Submits the new appointment.
     */
    onSubmit(): void {
        this.appointmentService.putAppointment(this.id, this.appointment).subscribe(() => {
            this.id = uuidv4();
            this.router.navigate(['/appointments']);
        });
    }
}

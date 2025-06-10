import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import { FormsModule } from '@angular/forms'; // Import FormsModule
import {NgForOf, NgIf} from '@angular/common';
import {AppointmentDetails} from '../../../appointment/model/appointment-details';
import {AppointmentService} from '../../../appointment/service/appointment.service';
import {Doctor} from '../../model/doctor';
import {DoctorService} from '../../service/doctor.service';
import {Appointments} from '../../../appointment/model/appointments';
import {Observable} from 'rxjs';
import {Appointment} from '../../../appointment/model/appointment';
import {Doctors} from '../../model/doctors'; // Import NgIf


@Component({
  selector: 'app-doctor-list',
  imports: [FormsModule, NgIf, RouterLink, NgForOf], // Add FormsModule to imports
  templateUrl: './doctor-list.component.html',
  standalone: true,
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent implements OnInit {
  /**
   * @param service doctor service
   */
  constructor(private service: DoctorService) {}

  /**
   * Available doctors.
   */
  doctors: Doctors | undefined;

  ngOnInit(): void {
    this.service.getDoctors().subscribe(doctors => this.doctors = doctors);
  }

  /**
   * Deletes selected doctor.
   *
   * @param doctor to be removed
   */
  onDelete(doctor: Doctor): void {
    this.service.deleteDoctor(doctor.id).subscribe(() => this.ngOnInit());
  }
}

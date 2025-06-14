import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import { FormsModule } from '@angular/forms'; // Import FormsModule
import {NgForOf, NgIf} from '@angular/common';
import {AppointmentDetails} from '../../../appointment/model/appointment-details';
import {AppointmentService} from '../../../appointment/service/appointment.service';
import {Doctor} from '../../model/doctor';
import {DoctorService} from '../../service/doctor.service';
import {Appointments} from '../../../appointment/model/appointments';
import {Observable} from 'rxjs'; // Import NgIf


@Component({
  selector: 'app-doctor-view',
  imports: [FormsModule, NgIf, RouterLink, NgForOf], // Add FormsModule to imports
  templateUrl: './doctor-view.component.html',
  standalone: true,
  styleUrls: ['./doctor-view.component.css']
})
export class DoctorViewComponent implements OnInit {
  /**
   * Single doctor.
   */
  doctor: Doctor | undefined;
  appointments: Appointments | undefined;

  /**
   *
   * @param service appointment service
   * @param route activated route
   * @param router router
   */
  constructor(private service: DoctorService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getDoctor(params['uuid'])
        .subscribe(doctor => this.doctor = doctor);
      this.service.getDoctorAppointments(params['uuid'])
        .subscribe(appointments => this.appointments = appointments);
    });

  }
}

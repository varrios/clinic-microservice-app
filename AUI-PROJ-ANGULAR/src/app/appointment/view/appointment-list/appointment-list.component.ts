import { Component, OnInit } from '@angular/core';
import { AppointmentService } from "../../service/appointment.service";
import { Appointments } from "../../model/appointments";
import { Appointment } from "../../model/appointment";
import { FormsModule } from '@angular/forms';
// import {NgFor, NgIf} from '@angular/common';
import {RouterLink} from '@angular/router';
// import {BrowserModule} from '@angular/platform-browser';
import { CommonModule } from '@angular/common'


@Component({
  selector: 'app-appointment-list',
  imports: [FormsModule, RouterLink, CommonModule],
  templateUrl: './appointment-list.component.html',
  standalone: true,
  styleUrls: ['./appointment-list.component.css']
})
export class AppointmentListComponent implements OnInit{

  /**
   * @param service appointments service
   */
  constructor(private service: AppointmentService) {}

  /**
   * Available appointments.
   */
  appointments: Appointments | undefined;

  ngOnInit(): void {
    this.service.getAppointments().subscribe(appointments => this.appointments = appointments);
  }

  /**
   * Deletes selected appointment.
   *
   * @param appointment to be removed
   */
  onDelete(appointment: Appointment): void {
    this.service.deleteAppointment(appointment.id).subscribe(() => this.ngOnInit());
  }
}

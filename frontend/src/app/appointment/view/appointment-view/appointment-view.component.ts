import { Component, OnInit } from '@angular/core';
import { AppointmentService } from "../../service/appointment.service";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import { AppointmentDetails } from "../../model/appointment-details";
import { FormsModule } from '@angular/forms'; // Import FormsModule
import { NgIf } from '@angular/common'; // Import NgIf


@Component({
  selector: 'app-appointment-view',
  imports: [FormsModule, NgIf, RouterLink], // Add FormsModule to imports
  templateUrl: './appointment-view.component.html',
  standalone: true,
  styleUrls: ['./appointment-view.component.css']
})
export class AppointmentViewComponent implements OnInit {
  /**
   * Single appointment.
   */
  appointment: AppointmentDetails | undefined;

  /**
   *
   * @param service appointment service
   * @param route activated route
   * @param router router
   */
  constructor(private service: AppointmentService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getAppointment(params['uuid'])
        .subscribe(appointment => this.appointment = appointment)
    });
  }
}

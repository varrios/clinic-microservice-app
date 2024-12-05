import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppointmentDetails} from '../model/appointment-details';
import {Appointments} from '../model/appointments';
import {AppointmentForm} from '../model/appointment-form';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {}

  /**
   * Fetches all appointments.
   *
   * @return list of appointments
   */
  getAppointments(): Observable<Appointments> {
    return this.http.get<Appointments>('/api/appointments');
  }

  /**
   * Fetches single appointment.
   *
   * @param uuid appointment's id
   * @return single appointment
   */
  getAppointment(uuid: string): Observable<AppointmentDetails> {
    return this.http.get<AppointmentDetails>('/api/appointments/' + uuid);
  }

  /**
   * Removes single appointment.
   *
   * @param uuid appointment's id
   */
  deleteAppointment(uuid: string): Observable<any> {
    return this.http.delete('/api/appointments/' + uuid);
  }

  /**
   * Updates single appointment.
   *
   * @param uuid appointment's id
   * @param request request body
   */
  putAppointment(uuid: string, request: AppointmentForm): Observable<any> {
    return this.http.put('/api/appointments/' + uuid, request);
  }
}

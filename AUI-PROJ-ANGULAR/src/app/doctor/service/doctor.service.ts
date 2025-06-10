import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Doctors} from '../model/doctors';
import {Observable} from 'rxjs';
import {Doctor} from '../model/doctor';
import {Appointments} from '../../appointment/model/appointments';
import {AppointmentForm} from '../../appointment/model/appointment-form';
import {DoctorForm} from '../model/doctor-form';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all doctors.
   *
   * @return list of doctors
   */
  getDoctors(): Observable<Doctors> {
    return this.http.get<Doctors>('/api/doctors');
  }


    /**
   * Fetches single doctor.
   *
   * @param uuid doctor's id
   * @return single doctor
   */
  getDoctor(uuid: string): Observable<Doctor> {
    return this.http.get<Doctor>('/api/doctors/' + uuid);
  }

  getDoctorAppointments(uuid: string): Observable<Appointments> {
    return this.http.get<Appointments>('/api/doctors/' + uuid + '/appointments');
  }

  deleteDoctor(uuid: string): Observable<any> {
    return this.http.delete('/api/doctors/' + uuid);
  }

  putDoctor(uuid: string, request: DoctorForm): Observable<any> {
    return this.http.put('/api/doctor/' + uuid, request);
  }

}

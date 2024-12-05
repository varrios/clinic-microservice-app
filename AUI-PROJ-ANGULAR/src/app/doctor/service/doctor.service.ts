import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Doctors} from '../model/doctors';
import {Observable} from 'rxjs';

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
}

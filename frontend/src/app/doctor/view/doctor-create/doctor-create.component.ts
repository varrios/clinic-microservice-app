import {Component, OnInit} from '@angular/core';
import {DoctorForm} from '../../model/doctor-form';
import {DoctorService} from '../../service/doctor.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {Doctors} from '../../model/doctors';
import {NgForOf, NgIf} from '@angular/common';
import {v4 as uuidv4} from 'uuid';

@Component({
  selector: 'app-appointment-edit',
  templateUrl: './doctor-create.component.html',
  imports: [
    FormsModule, NgIf, NgForOf
  ],
  standalone: true,
  styleUrl: './doctor-create.component.css'
})
export class DoctorCreateComponent{

  /**
   * Doctor's id.
   */
  id: string = uuidv4();
  /**
   * Single doctor.
   */
  doctor: DoctorForm = {
        fullName: '',
        specialization: '',
    };



  constructor(
        private doctorService: DoctorService,
        private router: Router
    ) { }


  /**
   * Updates doctor.
   */
  onSubmit(): void {
      this.doctorService.putDoctor(this.id, this.doctor).subscribe(() => {
          this.id = uuidv4();
          this.router.navigate(['/doctors']);
      });
  }


}

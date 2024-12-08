import {Component, OnInit} from '@angular/core';
import {DoctorForm} from '../../model/doctor-form';
import {DoctorService} from '../../service/doctor.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {Doctors} from '../../model/doctors';
import {NgForOf, NgIf} from '@angular/common';

@Component({
  selector: 'app-appointment-edit',
  templateUrl: './doctor-edit.component.html',
  imports: [
    FormsModule, NgIf, NgForOf
  ],
  standalone: true,
  styleUrl: './doctor-edit.component.css'
})
export class DoctorEditComponent implements OnInit{

  /**
   * Doctor's id.
   */
  uuid: string | undefined;

  /**
   * Single doctor.
   */
  doctor: DoctorForm | undefined;

  /**
   * Single doctor.
   */
  original: DoctorForm | undefined;


  constructor(
    private doctorService: DoctorService,
    private route: ActivatedRoute,
    private router: Router,
  ){
  }

  ngOnInit() {
    this.route.params.subscribe(params => {

      this.doctorService.getDoctor(params['uuid'])
        .subscribe(doctor => {
          this.uuid = doctor.id;
          this.doctor = {
            specialization: doctor.specialization,
            fullName: doctor.fullName
          };
          this.original = {...this.doctor};

        });
    });
  }
  /**
   * Updates doctor.
   */
  onSubmit(): void {
    this.doctorService.putDoctor(this.uuid!, this.doctor!)
      .subscribe(() => this.router.navigate(['/doctors']));
  }


}

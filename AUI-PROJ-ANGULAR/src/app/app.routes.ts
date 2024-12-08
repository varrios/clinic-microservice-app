import {RouterModule, Routes} from '@angular/router';
import {AppointmentListComponent} from './appointment/view/appointment-list/appointment-list.component';
import {AppointmentViewComponent} from './appointment/view/appointment-view/appointment-view.component';
import {AppointmentEditComponent} from './appointment/view/appointment-edit/appointment-edit.component';
import {NgModule} from '@angular/core';
import {DoctorViewComponent} from './doctor/view/doctor-view/doctor-view.component';
import {DoctorListComponent} from './doctor/view/doctor-list/doctor-list.component';
import {DoctorEditComponent} from './doctor/view/doctor-edit/doctor-edit.component';
import {AppointmentCreateComponent} from './appointment/view/appointment-create/appointment-create.component';
import {DoctorCreateComponent} from './doctor/view/doctor-create/doctor-create.component';

export const routes: Routes = [
    {
        component: AppointmentListComponent,
        path: "appointments"
    },
    {
        component: AppointmentViewComponent,
        path: "appointments/:uuid"
    }
    ,
    {
        component: AppointmentEditComponent,
        path: "appointments/:uuid/edit"
    },
    {
        component: DoctorViewComponent,
        path: "doctors/:uuid"
    },
    {
        component: DoctorEditComponent,
        path: "doctors/:uuid/edit"
    },
    {
      component: DoctorListComponent,
      path: "doctors"
    },
    {
      component: AppointmentCreateComponent,
      path: "appointment/create"
    },
    {
        component: DoctorCreateComponent,
        path: "doctor/create"
    }
];

/**
 * Global routing module.
 */
@NgModule({
    imports: [
      RouterModule.forRoot(routes)
    ],
    exports: [
      RouterModule
    ]
  })

export class AppRoutingModule {

}

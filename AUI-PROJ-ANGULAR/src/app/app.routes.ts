import {RouterModule, Routes} from '@angular/router';
import {AppointmentListComponent} from './appointment/view/appointment-list/appointment-list.component';
import {AppointmentViewComponent} from './appointment/view/appointment-view/appointment-view.component';
import {AppointmentEditComponent} from './appointment/view/appointment-edit/appointment-edit.component';
import {NgModule} from '@angular/core';

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
        path: "characters/:uuid/edit"
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

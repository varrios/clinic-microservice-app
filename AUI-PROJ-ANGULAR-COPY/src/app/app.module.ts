import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { provideHttpClient } from '@angular/common/http';
import { RouterModule } from '@angular/router'; 


import { AppointmentListComponent } from './appointment/view/appointment-list/appointment-list.component';
import { AppointmentViewComponent } from './appointment/view/appointment-view/appointment-view.component';
import { AppointmentEditComponent } from './appointment/view/appointment-edit/appointment-edit.component';
import { AppointmentService } from './appointment/service/appointment.service';
import { FormsModule } from "@angular/forms";

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    AppointmentListComponent,
    AppointmentViewComponent,
    AppointmentEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],

  providers: [
    provideHttpClient(), AppointmentService
  ],
  bootstrap: [
    AppComponent,
  ]
})
export class AppModule {

}


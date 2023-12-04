import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './Components/register/register.component';
import { DoctorsComponent } from './Components/staff/doctors/doctors.component';
import { SidebarComponent } from './Components/sidebar/sidebar.component';
import { HttpClientModule } from '@angular/common/http';
import { StaffComponent } from './Components/staff/staff.component';
import { StaffService } from './Components/staff/staff.service';
import { DashboardComponent } from './Components/dashboard/dashboard.component';
import { WardComponent } from './Components/ward/ward.component';
import { AppointmentsComponent } from './Components/appointments/appointments.component';
import { PrescriptionComponent } from './Components/prescription/prescription.component';
import { RegisterPatientComponent } from './Components/register-patient/register-patient.component';
import { PatientsComponent } from './Components/patients/patients.component';
import { ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './Components/login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EditPatientComponent } from './Components/patients/edit-patient/edit-patient.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ViewPatientComponent } from './Components/patients/view-patient/view-patient.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    DoctorsComponent,
    SidebarComponent,
    DashboardComponent,
    WardComponent,
    AppointmentsComponent,
    PrescriptionComponent,
    RegisterPatientComponent,
    PatientsComponent,
    StaffComponent,
    EditPatientComponent,
    ViewPatientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    NgbModule
  ],
  providers: [StaffService],
  bootstrap: [AppComponent]
})
export class AppModule { }

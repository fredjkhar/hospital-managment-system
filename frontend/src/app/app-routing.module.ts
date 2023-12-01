import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './Components/login/login.component';
import { RegisterComponent } from './Components/register/register.component';
import { DoctorsComponent } from './Components/staff/doctors/doctors.component';
import { DashboardComponent } from './Components/dashboard/dashboard.component';
import { WardComponent } from './Components/ward/ward.component';
import { AppointmentsComponent } from './Components/appointments/appointments.component';
import { PrescriptionComponent } from './Components/prescription/prescription.component';
import { PatientsComponent } from './Components/patients/patients.component';
import { RegisterPatientComponent } from './Components/register-patient/register-patient.component';
import { StaffComponent } from './Components/staff/staff.component';
import { EditPatientComponent } from './Components/patients/edit-patient/edit-patient.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'appointments', component: AppointmentsComponent },
  { path: 'departments', component: WardComponent },
  { path: 'prescriptions', component: PrescriptionComponent },
  { path: 'doctors', component: DoctorsComponent },
  { path: 'patients', component: PatientsComponent },
  { path: 'patients/edit-patient/:id', component: EditPatientComponent },
  { path: 'register-patient', component: RegisterPatientComponent },
  { path: 'addEmp', component: StaffComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', redirectTo: '/login' },];

@NgModule({
  imports: [RouterModule.forRoot(routes, { bindToComponentInputs: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
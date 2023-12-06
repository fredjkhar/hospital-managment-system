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
import { AddPrescriptionComponent } from './Components/prescription/add-prescription/add-prescription.component';
import { ViewPatientComponent } from './Components/patients/view-patient/view-patient.component';
import { AddPatientComponent } from './Components/ward/add-patient/add-patient.component';
import { RequestPatientComponent } from './Components/ward/request-patient/request-patient.component';
import { DischargePatientComponent } from './Components/ward/discharge-patient/discharge-patient.component';
import { AdmitPatientRequestComponent } from './Components/ward/admit-patient-request/admit-patient-request.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'appointments', component: AppointmentsComponent },
  { path: 'departments', component: WardComponent },
  { path: 'departments/add-patient/:id', component: AddPatientComponent },
  { path: 'departments/request-patient/:id', component: RequestPatientComponent },
  { path: 'departments/discharge-patient/:id', component: DischargePatientComponent },
  { path: 'departments/admit-patient-request/:id', component: AdmitPatientRequestComponent },
  { path: 'prescriptions', component: PrescriptionComponent },
  { path: 'doctors', component: DoctorsComponent },
  { path: 'patients', component: PatientsComponent },
  { path: 'patients/edit-patient/:id', component: EditPatientComponent },
  { path: 'patients/view-patient/:id', component: ViewPatientComponent },
  { path: 'register-patient', component: RegisterPatientComponent },
  { path: 'addEmp', component: StaffComponent },
  { path: 'prescriptions/add-prescription', component: AddPrescriptionComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', redirectTo: '/login' },];

@NgModule({
  imports: [RouterModule.forRoot(routes, { bindToComponentInputs: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Injectable } from '@angular/core';
import { Patient } from './patient.model';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PatientsService {
  private apiUrl = 'http://localhost:8080/api';

  private patients: Patient[] = [];

  static originalPatients = [
    { id: '1', fullname: 'rada', gender: 'm', address: '350 mt...', birthday: '11-12-2002', email: 'john.doe@example.com', contact: '123-456-7890' },
    { id: '2', fullname: 'Jane', gender: 'f', address: 'king edward', birthday: '11-12-2002', email: 'jane.smith@example.com', contact: '987-654-3210' },
  ];
  static placeholderPrescriptions = [
    { id: '1', patientId: '1', drugNumber: '1', drugName: 'Tylenol', unitsPerDay: 5, administrationNbrPerDay: 5, administrationMethod: 'IV', startDate: '2022-01-01', endDate: '2023-01-01' },
    { id: '2', patientId: '2', drugNumber: '2', drugName: 'Adderall', unitsPerDay: 10, administrationNbrPerDay: 2, administrationMethod: 'Pills', startDate: '2022-04-01', endDate: '2023-04-01' },
    { id: '3', patientId: '1', drugNumber: '1', drugName: 'Advil', unitsPerDay: 5, administrationNbrPerDay: 5, administrationMethod: 'IV', startDate: '2022-01-01', endDate: '2023-01-01' },
    { id: '4', patientId: '1', drugNumber: '1', drugName: 'Morphine', unitsPerDay: 5, administrationNbrPerDay: 5, administrationMethod: 'IV', startDate: '2022-01-01', endDate: '2023-01-01' },
  ];

  constructor(private http: HttpClient) { }

  getPatients(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/getPatientsList`);
  }

  getPatientById(id: number): Observable<any | undefined> {
    return this.http.get<any>(`${this.apiUrl}/consultPatientFile/${id}`);
  }

  deletePatient(id: number): void {
    this.patients.splice(id, 1);
  }

  dischargePatientFromWard(patientId: any, wardId: any): Observable<boolean> {
    return this.http.delete<boolean>(`${this.apiUrl}/ward/${wardId}/patients/${patientId}`)
  }

  getPatientsNotAssignedToWard(): Object[] {
    return PatientsService.originalPatients
  }

  getPatientsAdmittedToWard(wardId: any): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/ward/${wardId}/patients`)
  }

  getPatient(patientId: any): any {
    //this call should log the user that accessed the file
    return PatientsService.originalPatients.find(patient => patient.id === patientId)
  }

  getPatientPrescriptions(patientId: any): any[] {
    return PatientsService.placeholderPrescriptions.filter(prescription => prescription.patientId == patientId)
  }

  assignPatientToWard(wardId: any, patientId: any, patientAssignment: any): boolean {
    if (true) {
      console.log("successful assignment to ward ", wardId, " for patient ", patientId, " with additional info ", patientAssignment)
      return true;
    }
    console.log("unsuccessful assignment to ward")
    return false;
  }

  requestPatientToWard(wardId: any, patientId: any, patientRequest: any): boolean {
    if (true) {
      console.log("successful request of admission to ward ", wardId, " for patient ", patientId, " with additional info ", patientRequest)
      return true;
    }
    console.log("unsuccessful request of admission to ward")
    return false;
  }

  editPatient(id: string, patientData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/updatePatientFile/${id}`, patientData);
    // const indexToModify = PatientsService.originalPatients.findIndex(e => e.id === newPatient.id)
    // if (indexToModify != -1) {
    //   PatientsService.originalPatients[indexToModify] = newPatient
    //   console.log(PatientsService.originalPatients)
    //   return true
    // }
    // return false
  }

  getPatientAdmissionRequestsFromWard(wardId: any): Observable<any> {
    return this.http.get<any[]>(`${this.apiUrl}/ward/${wardId}/requests`);
  }

  addPrescription(newPrescription: any): any {
    return this.http.post(`${this.apiUrl}/prescribeMedication/`, newPrescription);
  }

  admitPatient(admissionCreateDTO: any): Observable<string> {
    return this.http.post<string>(`${this.apiUrl}/admitPatient`, admissionCreateDTO);
  }
}

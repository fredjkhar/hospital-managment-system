import { Injectable } from '@angular/core';
import { Patient } from './patient.model';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PatientsService {
  private apiUrl = 'BACKEND_API_URL'; 

  private patients: Patient[] = [];

  static originalPatients = [
    { id: '1', fullname: 'rada', gender: 'm', address: '350 mt...', birthday: '11-12-2002', email: 'john.doe@example.com', contact: '123-456-7890' },
    { id: '2', fullname: 'Jane', gender: 'f', address: 'king edward', birthday: '11-12-2002', email: 'jane.smith@example.com', contact: '987-654-3210' },
  ];

  constructor(private http: HttpClient) { }

  getPatients(): Observable<any[]> {
    const userRoleProperty = this.http.get<any[]>(`${this.apiUrl}/patients`);
    return userRoleProperty;
  }

  getPatientById(id: number): Observable<Patient | undefined> {
    const patient = this.patients.find((p) => p.Id === id);
    return of(patient);
  }

  deletePatient(id: number): void {
    this.patients.splice(id, 1);
  }

  editPatient(newPatient: any): boolean {
    const indexToModify = PatientsService.originalPatients.findIndex(e => e.id === newPatient.id)
    if (indexToModify != -1) {
      PatientsService.originalPatients[indexToModify] = newPatient
      console.log(PatientsService.originalPatients)
      return true
    }
    return false
  }
}

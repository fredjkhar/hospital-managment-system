import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, map, of } from 'rxjs';
import {
  Firestore,
  collection,
  collectionData,
  addDoc,
  CollectionReference,
  where,
  query,
  getDocs
} from '@angular/fire/firestore';

@Injectable({
  providedIn: 'root'
})
export class StaffService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient, private firestore: Firestore) { }

  getStaff(): Observable<any[]> {
    return collectionData(collection(this.firestore, 'staff'))
  }

  addEmployee(emp: any): void {
    addDoc(collection(this.firestore, 'staff'), emp)
  }

  deleteDoctor(doctorId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/doctors/${doctorId}`);
  }

  deletePatient(patientId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/patients/${patientId}`);
  }

  isUserNurse(): Observable<boolean> {
    return of(true)
    return this.getStaff().pipe(
      map((staff: any[]) => {
        const userRole = staff[0]?.userRoleProperty; 
        return userRole === 'nurse';
      })
    );
  }

  registerPatient(patientData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/registerPatient`, patientData);
  }
  
  // getNurseInfo(name: string, dept: string, userRole: 'nurse'): Observable<any[]> {
  //   const params = new HttpParams()
  //     .set('name', name)
  //     .set('dept', dept)
  //     .set('userRole', userRole);

  //   const nurseDetails = this.http.get<any[]>(`${this.apiUrl}/staff`, { params });
  //   return nurseDetails;
  // }
  
}

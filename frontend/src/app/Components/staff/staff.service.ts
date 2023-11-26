import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, map, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StaffService {
  private apiUrl = 'BACKEND_API_URL'; 

  constructor(private http: HttpClient) { }

  getStaff(): Observable<any[]> {
    const userRoleProperty = this.http.get<any[]>(`${this.apiUrl}/staff`);
    return userRoleProperty;
  }

  deleteDoctor(doctorId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/doctors/${doctorId}`);
  }

  deletePatient(patientId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/patients/${patientId}`);
  }

  isUserNurse(): Observable<boolean> {
    return this.getStaff().pipe(
      map((staff: any[]) => {
        const userRole = staff[0]?.userRoleProperty; 
        return userRole === 'nurse';
      })
    );
  }

  registerPatient(patientData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/patients`, patientData);
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

import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, map, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppointmentsService {

  private apiUrl = 'BACKEND_API_URL'; 

  constructor(private http: HttpClient) { }

  getAppointments(): Observable<any[]> {
    const userRoleProperty = this.http.get<any[]>(`${this.apiUrl}/staff`);
    return userRoleProperty;
  }

  deleteAppointment(rdvId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/rdv/${rdvId}`);
  }

}

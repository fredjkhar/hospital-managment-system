import { Injectable } from '@angular/core';
import { Patient } from './patient.model';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
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
import { doc, getDoc, setDoc } from 'firebase/firestore';

@Injectable({
  providedIn: 'root'
})
export class PatientsService {
  private apiUrl = 'BACKEND_API_URL';

  private patients: CollectionReference;
  private wards: CollectionReference;
  private prescriptions: CollectionReference;
  private admissionReq: CollectionReference

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

  constructor(private http: HttpClient, private firestore: Firestore) {
    this.patients = collection(this.firestore, 'patients')
    this.wards = collection(this.firestore, 'wards')
    this.prescriptions = collection(this.firestore, 'prescriptions')
    this.admissionReq = collection(this.firestore, 'admission_request')
  }

  getPatients(): Observable<any[]> {
    return collectionData(this.patients, { idField: 'dbid' })
  }

  //doesnt work rn, check viewpatient to see what to do
  async getPatientById(id: any): Promise<any> {
    // const data = await getDocs(query(this.patients, where("id", "==", id)))
    // console.log(data)
    // return data.docs[0]
    return getDoc(doc(this.patients, id))
  }

  registerPatient(patient: any): void {
    // addDoc(this.patients, patient)
    setDoc(doc(this.patients, patient.id), patient)
  }

  deletePatient(id: number): void {
    // this.patients.splice(id, 1);
  }

  getPatientsNotAssignedToWard(): Object[] {
    //do some filtering here
    return PatientsService.originalPatients
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
    addDoc(this.admissionReq, { wardId: wardId, patientId: patientId, ...patientRequest })
    if (true) {
      console.log("successful request of admission to ward ", wardId, " for patient ", patientId, " with additional info ", patientRequest)
      return true;
    }
    console.log("unsuccessful request of admission to ward")
    return false;
  }

  editPatient(editedPatient: any): void {
    // const indexToModify = PatientsService.originalPatients.findIndex(e => e.id === editedPatient.id)
    // if (indexToModify != -1) {
    //   PatientsService.originalPatients[indexToModify] = editedPatient
    //   console.log(PatientsService.originalPatients)
    //   return true
    // }
    // return false
    setDoc(doc(this.patients, editedPatient.id), editedPatient)
  }

  getPatientAdmissionRequestsFromWard(wardId: any): Observable<any> {
    return this.http.get<any[]>(`${this.apiUrl}/ward/${wardId}/requests`);
  }

  addPrescription(newPrescription: any): void {
    setDoc(doc(this.prescriptions, "" + newPrescription.drugNumber), newPrescription)
  }

  getPrescriptions(): Observable<any> {
    return collectionData(this.prescriptions, { idField: 'id' })
  }

  getWards(): Observable<any[]> {
    return collectionData(this.wards, { idField: 'dbid' })
  }
}

import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PatientsService {
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
  constructor() { }

  getPatients(): Object[] {
    //should get stuff from DB later on
    //ideally we would have a Patient[] as the return type, but shouldn't be a big deal rn
    return PatientsService.originalPatients
  }

  getPatient(patientId: any): any {
    //this call should log the user that accessed the file
    return PatientsService.originalPatients.find(patient => patient.id === patientId)
  }

  getPatientPrescriptions(patientId: any): any[] {
    return PatientsService.placeholderPrescriptions.filter(prescription => prescription.patientId == patientId)
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

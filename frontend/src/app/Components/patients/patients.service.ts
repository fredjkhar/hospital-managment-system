import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PatientsService {
  static originalPatients = [
    { id: '1', fullname: 'rada', gender: 'm', address: '350 mt...', birthday: '11-12-2002', email: 'john.doe@example.com', contact: '123-456-7890' },
    { id: '2', fullname: 'Jane', gender: 'f', address: 'king edward', birthday: '11-12-2002', email: 'jane.smith@example.com', contact: '987-654-3210' },
  ];
  constructor() { }

  getPatients(): Object[] {
    //should get stuff from DB later on
    //ideally we would have a Patient[] as the return type, but shouldn't be a big deal rn
    return PatientsService.originalPatients
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

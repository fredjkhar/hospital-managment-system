import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientsService } from '../../patients/patients.service';
import { Patient } from '../../patients/patient.model';

@Component({
  selector: 'app-discharge-patient',
  templateUrl: './discharge-patient.component.html',
  styleUrls: ['./discharge-patient.component.css']
})
export class DischargePatientComponent {
  wardId = null
  searchText: string = '';
  hasSearchResults: boolean = true;
  admittedPatients: any[] = [] //PatientsService.originalPatients
  constructor(private patientsService: PatientsService, private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.wardId = params['id']
    })
    this.patientsService.getPatientsAdmittedToWards().subscribe(admittedPatients => {
      console.log(admittedPatients)
      this.admittedPatients = admittedPatients.filter(admission => {
        console.log(admission)
        console.log(admission.wardId)
        console.log(this.wardId)
        console.log(admission.wardId == this.wardId)
        return admission.wardId == this.wardId
      })
    })
  }

  dischargePatient(patientId: any) {
    console.log("discharged patient ", patientId)
    // this.patientsService.dischargePatientFromWard(patientId, this.wardId)
  }

  search(): void {
    console.log('Search called', this.searchText);
    if (this.searchText.trim() === '') {
      this.admittedPatients = [...this.admittedPatients];
    } else {
      this.admittedPatients = this.admittedPatients.filter(item => {
        return (
          item.id.toLowerCase().includes(this.searchText.toLowerCase()) ||
          item.fullname.toLowerCase().includes(this.searchText.toLowerCase()) ||
          item.gender.toLowerCase().includes(this.searchText.toLowerCase()) ||
          item.address.toLowerCase().includes(this.searchText.toLowerCase()) ||
          item.birthday.toLowerCase().includes(this.searchText.toLowerCase()) ||
          item.email.toLowerCase().includes(this.searchText.toLowerCase()) ||
          item.contact.toLowerCase().includes(this.searchText.toLowerCase())
        );
      });
    }
    this.hasSearchResults = this.admittedPatients.length > 0;
  }
}


import { Component } from '@angular/core';
import { StaffService } from '../staff/staff.service';
import { Router } from '@angular/router';
import { Patient } from './patient.model';
import { PatientsService } from './patients.service';

@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.css']
})
export class PatientsComponent {
  searchText: string = '';
  originalPatients = [
    { Id: '1', fullname: 'rada', gender: 'm', address: '350 mt...', birthday: '11-12-2002', email: 'john.doe@example.com', contact: '123-456-7890' },
    { Id: '2', fullname: 'Jane', gender: 'f', address: 'king edward', birthday: '11-12-2002', email: 'jane.smith@example.com', contact: '987-654-3210' },
    { Id: '3', fullname: 'Jane', gender: 'f', address: 'king edward', birthday: '11-12-2002', email: 'jane.smith@example.com', contact: '987-654-3210' },
  ];
  Patients: any[] = [];
  hasSearchResults: boolean = true;
  selectedPatient: Patient | null = null;

  constructor(private patientService: PatientsService, private router: Router) { }

  ngOnInit(): void {
    this.loadPatients();
  }
  
  loadPatients() {
    // this.patientService.getPatients().subscribe((patients) => {
    //   this.Patients = patients;
    // });
    this.Patients = this.originalPatients;
  }

  search(): void {
    console.log('Search called', this.searchText); 
    if (this.searchText.trim() === '') {
      this.Patients = [...this.Patients];
    } else {
      this.Patients = this.Patients.filter(item => {
        return (
        item.Id.toLowerCase().includes(this.searchText.toLowerCase()) ||
        item.fullname.toLowerCase().includes(this.searchText.toLowerCase()) ||
        item.gender.toLowerCase().includes(this.searchText.toLowerCase()) ||
        item.address.toLowerCase().includes(this.searchText.toLowerCase()) ||
        item.birthday.toLowerCase().includes(this.searchText.toLowerCase()) ||
        item.email.toLowerCase().includes(this.searchText.toLowerCase()) ||
        item.contact.toLowerCase().includes(this.searchText.toLowerCase())
      );
    });
  }
  this.hasSearchResults = this.Patients.length > 0;
  }

  editPatient(patient: any): void {
    this.router.navigate(['patients', 'edit-patient', patient.id])
  }

  deletePatient(id: number) {
    this.patientService.deletePatient(id);
    this.loadPatients(); 
  }
  
  openRegistrationForm(): void {
    this.router.navigate(['/register-patient']);
  }

  showDetails(patient: Patient) {
    this.selectedPatient = this.selectedPatient === patient ? null : patient;
  }
}

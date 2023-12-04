import { Component } from '@angular/core';
import { StaffService } from '../staff/staff.service';
import { Router } from '@angular/router';
import { PatientsService } from './patients.service';

@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.css']
})
export class PatientsComponent {
  searchText: string = '';
  
  Patients: any[] = [];
  hasSearchResults: boolean = true;

  constructor(private StaffService: StaffService, private router: Router, private patientsService: PatientsService) { }

  ngOnInit(): void {
    this.loadStaff();
  }

  private loadStaff(): void {
    // this.StaffService.getStaff().subscribe(
    //   data => {
    //     this.Patients = data;
    //   },
    //   error => {
    //     console.error('Error loading Patients:', error);
    //   }
    // );
    this.Patients = [...this.patientsService.getPatients()];
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

  deletePatient(patient: any): void {
    this.StaffService.deletePatient(patient.id).subscribe(
      () => {
        this.Patients = this.Patients.filter(d => d.id !== patient.id);
        console.log('Patient deleted:', patient);
      },
      error => {
        console.error('Error deleting Patient:', error);
      }
    );
  }
  
  openRegistrationForm(): void {
    this.router.navigate(['/register-patient']);
  }

  viewPatientFile(patient: any): void {
    this.router.navigate(['patients', 'view-patient', patient.id])
  }
}

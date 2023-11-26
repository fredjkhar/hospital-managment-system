import { Component } from '@angular/core';
import { StaffService } from '../staff/staff.service';
import { Router } from '@angular/router';

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
  ];
  Patients: any[] = [];
  hasSearchResults: boolean = true;

  constructor(private StaffService: StaffService, private router: Router) { }

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
    this.Patients = [...this.originalPatients];
  }

  search(): void {
    console.log('Search called', this.searchText); 
    if (this.searchText.trim() === '') {
      this.Patients = [...this.originalPatients];
    } else {
      this.Patients = this.originalPatients.filter(item => {
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

  editPatient(doctor: any): void {
    console.log('Edit doctor:', doctor);
  }

  deletePatient(doctor: any): void {
    this.StaffService.deletePatient(doctor.id).subscribe(
      () => {
        this.Patients = this.Patients.filter(d => d.id !== doctor.id);
        console.log('Patient deleted:', doctor);
      },
      error => {
        console.error('Error deleting Patient:', error);
      }
    );
  }
  
  openRegistrationForm(): void {
    this.router.navigate(['/register-patient']);
  }
}

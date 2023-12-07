import { Component, OnInit } from '@angular/core';
import { StaffService } from '../staff.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-staff',
  templateUrl: './doctors.component.html',
  styleUrls: ['./doctors.component.css']
})
export class DoctorsComponent {
  searchText: string = '';
  originalDoctors = [
    { employeeNbr: '1', name: 'rada', role: 'Cardiology', email: 'john.doe@example.com', contact: '123-456-7890' },
    { employeeNbr: '2', name: 'Dr. Jane Smith', role: 'Orthopedics', email: 'jane.smith@example.com', contact: '987-654-3210' },
  ];
  Doctors: any[] = [];
  hasSearchResults: boolean = true;

  constructor(private StaffService: StaffService, private router: Router) { }

  ngOnInit(): void {
    this.loadStaff();
  }

  private loadStaff(): void {
    this.StaffService.getStaff().subscribe(
      data => {
        this.Doctors = data;
      })
  }

  search(): void {
    console.log('Search called', this.searchText); 
    if (this.searchText.trim() === '') {
      // If the search text is empty, reset Doctors to the original state
      this.loadStaff()
    } else {
      this.Doctors = this.Doctors.filter(item => {
        return (
        item.employeeNbr.toLowerCase().includes(this.searchText.toLowerCase()) ||
        item.name.toLowerCase().includes(this.searchText.toLowerCase()) ||
        item.role.toLowerCase().includes(this.searchText.toLowerCase()) ||
        item.email.toLowerCase().includes(this.searchText.toLowerCase()) ||
        item.contact.toLowerCase().includes(this.searchText.toLowerCase())
      );
    });
  }
  this.hasSearchResults = this.Doctors.length > 0;
  }

  editDoctor(doctor: any): void {
    console.log('Edit doctor:', doctor);
  }

  deleteDoctor(doctor: any): void {
    this.StaffService.deleteDoctor(doctor.id).subscribe(
      () => {
        this.Doctors = this.Doctors.filter(d => d.id !== doctor.id);
        console.log('Doctor deleted:', doctor);
      },
      error => {
        console.error('Error deleting doctor:', error);
      }
    );
  }

  openRegistrationForm(): void {
    this.router.navigate(['/addEmp']);
  }
}

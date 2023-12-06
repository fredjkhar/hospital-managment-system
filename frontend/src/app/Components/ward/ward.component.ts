import { Component } from '@angular/core';
import { StaffService } from '../staff/staff.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ward',
  templateUrl: './ward.component.html',
  styleUrls: ['./ward.component.css']
})
export class WardComponent {
  readonly WARD_COMPLETE = "Complete";
  searchText: string = '';
  originalWards = [
    { id: '1', name: 'Cardiology', nurse: 'Leila', location: 'Vanier', beds: '123', telExt: '7890', status: 'Incomplete', },
    { id: '2', name: 'Emergency', nurse: 'Assia', location: 'Downtown', beds: '987', telExt: '5433', status: 'Complete' },
    { id: '3', name: 'Out-patient ward', nurse: 'Bingus', location: 'Kanata', beds: '234', telExt: '3123', status: 'Complete' },
  ];
  Wards: any[] = [];
  // Nurse: any[] = [];
  hasSearchResults: boolean = true;
  Nurse = [
    { userRole: 'nurse', name: 'leila', telExt: '2145', bipExt: '1234', dept: 'Cardiology' },
    { userRole: 'dr', name: 'b', telExt: '1224', bipExt: '123', dept: 'O' },
  ];
  selectedNurse: any;

  constructor(private StaffService: StaffService, private router: Router) { }

  ngOnInit(): void {
    this.loadStaff();
  }

  private loadStaff(): void {
    // this.StaffService.getStaff().subscribe(
    //   data => {
    //     this.Doctors = data;
    //   },
    //   error => {
    //     console.error('Error loading Doctors:', error);
    //   }
    // );
    this.Wards = [...this.originalWards];
  }

  search(): void {
    console.log('Search called', this.searchText);
    if (this.searchText.trim() === '') {
      this.Wards = [...this.originalWards];
    } else {
      this.Wards = this.originalWards.filter(item => {
        return (
          item.id.toLowerCase().includes(this.searchText.toLowerCase()) ||
          item.name.toLowerCase().includes(this.searchText.toLowerCase()) ||
          item.nurse.toLowerCase().includes(this.searchText.toLowerCase()) ||
          item.location.toLowerCase().includes(this.searchText.toLowerCase()) ||
          item.beds.toLowerCase().includes(this.searchText.toLowerCase()) ||
          item.telExt.toLowerCase().includes(this.searchText.toLowerCase()) ||
          item.status.toLowerCase().includes(this.searchText.toLowerCase())
        );
      });
    }
    this.hasSearchResults = this.Wards.length > 0;
  }

  editWard(ward: any): void {
    console.log('Edit doctor:', ward);
  }

  dischargePatientFromWard(ward: any): void {
    this.router.navigate(['departments', 'discharge-patient', ward.id])
  }

  showNurseDetails(name: string, dept: string, userRole: string): void {
    // this.StaffService.getStaff().subscribe(
    //   data => {
    //         this.Nurse = data;
    //       },
    //       error => {
    //         console.error('Error loading Doctors:', error);
    //       }
    // )
    const nurse = this.Nurse.find(n => n.name === name && n.dept === dept && n.userRole === 'nurse');
    if (nurse) {
      this.selectedNurse = nurse;
    }
    console.log('Show details:', this.selectedNurse);
  }

  closeNurseDetails(): void {
    this.selectedNurse = null;
  }

  addPatientToWard(ward: any): void {
    this.router.navigate(['departments', 'add-patient', ward.id])
  }

  requestPatientAdmissionToWard(ward: any): void {
    this.router.navigate(['departments', 'request-patient', ward.id])
  }
}

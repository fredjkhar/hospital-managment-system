import { Component } from '@angular/core';
import { StaffService } from '../staff/staff.service';

@Component({
  selector: 'app-ward',
  templateUrl: './ward.component.html',
  styleUrls: ['./ward.component.css']
})
export class WardComponent {

  searchText: string = '';
  originalWards = [
    { Id: '1', name: 'Cardiology', nurse: 'leila', location: 'vanier', beds: '123', telExt: '7890', status: 'imcomplet',},
    { Id: '2', name: 'Emergency', nurse: 'assia', location: 'downtown', beds: '987', telExt: '7890', status:'complet'},
  ];
  Wards: any[] = [];
  // Nurse: any[] = [];
  hasSearchResults: boolean = true;
  Nurse = [
    { userRole: 'nurse',name: 'leila', telExt: '2145', bipExt: '1234',dept:'Cardiology'},
    { userRole: 'dr', name: 'b', telExt: '1224', bipExt: '123', dept: 'O'},
  ];
  selectedNurse: any;

  constructor(private StaffService: StaffService) { }

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
        item.Id.toLowerCase().includes(this.searchText.toLowerCase()) ||
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

  deleteWard(ward: any): void {
    this.StaffService.deleteDoctor(ward.id).subscribe(
      () => {
        this.Wards = this.Wards.filter(d => d.id !== ward.id);
        console.log('Doctor deleted:', ward);
      },
      error => {
        console.error('Error deleting doctor:', error);
      }
    );
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
}

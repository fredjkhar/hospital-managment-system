import { Component } from '@angular/core';
import { AppointmentsService } from './appointments.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css']
})
export class AppointmentsComponent {
  searchText: string = '';
  originalAppointments = [
    { id: '1', patient: 'rada', doctor: 'd2erm', date: '11-12-2002', reasonVisit: 'sdfbejknwdq', location: 'qc'},
    { id: '2', patient: 'Jane', doctor: 'fqdw', date: '11-12-2002', reasonVisit: 'qdewfregthryu,ikyujtyhrtge', location: 'On'},
  ];
  Appointments: any[] = [];
  hasSearchResults: boolean = true;
  appointmentForm: FormGroup = this.fb.group({
    patientName: ['', Validators.required],
    doctor: ['', Validators.required],
    appointmentDate: ['', Validators.required],
    appointmentTime: ['', Validators.required],
    reason: ['', Validators.required],
    birthday: ['', Validators.required],
    gender: ['', Validators.required], 
    telNum: ['', Validators.required] 
  });
  constructor(private fb: FormBuilder, private AppointmentsService: AppointmentsService, private router: Router) { }

  ngOnInit(): void {
    this.appointmentForm = this.fb.group({
      patientName: ['', Validators.required],
      doctor: ['', Validators.required],
      appointmentDate: ['', Validators.required],
      appointmentTime: ['', Validators.required],
      reason: ['', Validators.required],
      birthday: ['', Validators.required],
      gender: ['', Validators.required], 
      telNum: ['', Validators.required] 
    });
  }

  private loadStaff(): void {
    // this.AppointmentsService.getAppointments().subscribe(
    //   data => {
    //     this.Appointments = data;
    //   },
    //   error => {
    //     console.error('Error loading Appointment:', error);
    //   }
    // );
    this.Appointments = [...this.originalAppointments];
  }

  search(): void {
    console.log('Search called', this.searchText); 
    if (this.searchText.trim() === '') {
      this.Appointments = [...this.originalAppointments];
    } else {
      this.Appointments = this.originalAppointments.filter(item => {
        return (
        item.id.toLowerCase().includes(this.searchText.toLowerCase()) ||
        item.patient.toLowerCase().includes(this.searchText.toLowerCase()) ||
        item.doctor.toLowerCase().includes(this.searchText.toLowerCase()) ||
        item.date.toLowerCase().includes(this.searchText.toLowerCase()) ||
        item.reasonVisit.toLowerCase().includes(this.searchText.toLowerCase()) ||
        item.location.toLowerCase().includes(this.searchText.toLowerCase())
      );
    });
  }
  this.hasSearchResults = this.Appointments.length > 0;
  }

  editAppointment(rdv: any): void {
    console.log('Edit rdv:', rdv);
  }

  deleteAppointment(rdv: any): void {
    this.AppointmentsService.deleteAppointment(rdv.id).subscribe(
      () => {
        this.Appointments = this.Appointments.filter(d => d.id !== rdv.id);
        console.log('Appointment deleted:', rdv);
      },
      error => {
        console.error('Error deleting Appointment:', error);
      }
    );
  }
  
  openRegistrationForm(): void {
    this.router.navigate(['/book-rdv']);
  }

  onSubmit() {
    if (this.appointmentForm.valid) {
      console.log("Form submitted:", this.appointmentForm.value);
    } else {
      console.log("Form is invalid.");
    }
    this.router.navigate(["dashboard"])
  }
}

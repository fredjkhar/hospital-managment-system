import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StaffService } from '../staff/staff.service';

@Component({
  selector: 'app-register',
  templateUrl: './register-patient.component.html',
  styleUrls: ['./register-patient.component.css']
})
export class RegisterPatientComponent {
  registrationForm: FormGroup;

  constructor(private fb: FormBuilder, private staffService: StaffService) {
    this.registrationForm = this.fb.group({
      insuranceNumber: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      address: ['', Validators.required],
      phoneNumber: ['', Validators.required],
      dateOfBirth: ['', Validators.required],
      gender: ['', Validators.required],
      maritalStatus: ['', Validators.required],
      familyDoctor: ['', Validators.required],
      nextOfKin: this.fb.group({
        fullName: ['', Validators.required],
        relationship: ['', Validators.required],
        kinAddress: ['', Validators.required],
        kinPhoneNumber: ['', Validators.required],
      })
    });
  }

  onSubmit() {
    if (this.registrationForm.valid) {
      const formData = this.registrationForm.value;
  
      this.staffService.registerPatient(formData).subscribe(
        response => {
          console.log('Patient registered successfully', response);
          this.registrationForm.reset();
        },
        error => {
          console.error('Error registering patient', error);
        }
      );
    }
  }
}

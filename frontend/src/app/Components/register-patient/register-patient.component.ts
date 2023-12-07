import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StaffService } from '../staff/staff.service';
import { Router } from '@angular/router';
import { PatientsService } from '../patients/patients.service';

@Component({
  selector: 'app-register',
  templateUrl: './register-patient.component.html',
  styleUrls: ['./register-patient.component.css']
})
export class RegisterPatientComponent {
  registrationForm: FormGroup;

  constructor(private fb: FormBuilder, private patientsService: PatientsService, private router: Router) {
    this.registrationForm = this.fb.group({
      insuranceNumber: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      address: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      tel: ['', Validators.required],
      dob: ['', Validators.required],
      gender: ['', Validators.required],
      maritalStatus: ['', Validators.required],
      familyDoctor: ['', Validators.required],
      nextOfKinName: ['', Validators.required],
      relationship: ['', Validators.required],
      kinAddress: ['', Validators.required],
      kinPhoneNumber: ['', Validators.required],

    });
  }

  onSubmit() {
    if (this.registrationForm.valid) {
      const formData = this.registrationForm.value;
      console.log(formData)
      const nextOfKin = { fullname: formData.nextOfKinName, relationship: formData.relationship, address: formData.kinAddress, tel: formData.kinPhoneNumber }
      const patient = {
        id: formData.insuranceNumber,
        fullname: formData.firstName + " " + formData.lastName,
        address: formData.address,
        tel: formData.tel,
        dob: formData.dob,
        email: formData.email,
        gender: formData.gender,
        maritalStatus: formData.maritalStatus,
        familyDoctor: formData.familyDoctor,
        nextOfKin: nextOfKin,
      }
      this.patientsService.registerPatient(patient)
      this.router.navigate(["patients"])
    }
  }
}

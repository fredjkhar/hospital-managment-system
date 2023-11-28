import { Component, OnInit } from '@angular/core';
import { StaffService } from './staff.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent {
  registrationForm: FormGroup;

  constructor(private staffService: StaffService, private fb: FormBuilder){
    this.registrationForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      job: ['', Validators.required],
      telephoneNumber: ['', Validators.required],
      Email: ['', Validators.required]
    })}

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

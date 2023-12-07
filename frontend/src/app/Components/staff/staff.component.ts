import { Component, OnInit } from '@angular/core';
import { StaffService } from './staff.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent {
  registrationForm: FormGroup;

  constructor(private staffService: StaffService, private fb: FormBuilder, private router: Router) {
    this.registrationForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      job: ['', Validators.required],
      telephoneNumber: ['', Validators.required],
      Email: ['', Validators.required],
      empId: ['', Validators.required]
    })
  }

  onSubmit() {
    const emp = this.registrationForm.value;
    this.staffService.addEmployee({name: emp.firstName + " " + emp.lastName, email: emp.Email, role: emp.job, contact: emp.telephoneNumber, employeeNbr: emp.empId})
    this.router.navigate(["doctors"])
  }
}

import { Component } from '@angular/core';
import { PatientsService } from '../patients.service';
import { ActivatedRoute } from '@angular/router';
import { OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-edit-patient',
  templateUrl: './edit-patient.component.html',
  styleUrls: ['./edit-patient.component.css']
})
export class EditPatientComponent {
  id: string;
  isloading: boolean = true;
  patientForm: FormGroup;

  get fullname(): AbstractControl<string> { return <AbstractControl>this.patientForm.get('fullname'); }
  get gender(): AbstractControl<string> { return <AbstractControl>this.patientForm.get('gender'); }
  get address(): AbstractControl<string> { return <AbstractControl>this.patientForm.get('address'); }
  get dob(): AbstractControl<string> { return <AbstractControl>this.patientForm.get('birthday'); }
  get email(): AbstractControl<string> { return <AbstractControl>this.patientForm.get('email'); }
  get tel(): AbstractControl<string> { return <AbstractControl>this.patientForm.get('contact'); }

  constructor(private builder: FormBuilder, private patientsService: PatientsService, private route: ActivatedRoute) {
    this.id = ''
    this.patientForm = this.builder.group({
      fullname: ['', [Validators.required]],
      gender: ['', Validators.required],
      address: ['', [Validators.required]],
      dob: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      maritalStatus: ['', Validators.required],
      familyDoctor: ['', Validators.required],
      
      //phone number validator might be overkill
      // tel: ['', [Validators.required, Validators.pattern('[1-9]\\d{2}[1-9]\\d{6}')]], 
      tel: ['', Validators.required],
      nextOfKin: this.builder.group({
        fullname: ['', Validators.required],
        relationship: ['', Validators.required],
        address: ['', Validators.required],
        tel: ['', Validators.required],
      })
    });
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });
    this.patientsService.getPatients().subscribe(patients => {
      let patient = patients.find(patient => patient.id == this.id)
      // console.log(patient)
      delete patient.id
      delete patient.dbid
      this.patientForm.setValue(patient)
      this.isloading=false;
    })
  }

  onSubmit() {
    this.patientsService.editPatient({id: this.id, ...this.patientForm.value})
    // console.log("submitted ", this.patientForm.value)
  }
}

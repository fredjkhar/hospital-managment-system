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
  private routeSub?: Subscription;
  id: string;
  patientForm: FormGroup;

  get fullname(): AbstractControl<string> { return <AbstractControl>this.patientForm.get('fullname'); }
  get gender(): AbstractControl<string> { return <AbstractControl>this.patientForm.get('gender'); }
  get address(): AbstractControl<string> { return <AbstractControl>this.patientForm.get('address'); }
  get birthday(): AbstractControl<string> { return <AbstractControl>this.patientForm.get('birthday'); }
  get email(): AbstractControl<string> { return <AbstractControl>this.patientForm.get('email'); }
  get contact(): AbstractControl<string> { return <AbstractControl>this.patientForm.get('contact'); }

  constructor(private builder: FormBuilder, private patientsService: PatientsService, private route: ActivatedRoute) {
    this.id = ''
    this.patientForm = this.builder.group({
      fullname: ['', [Validators.required]],
      gender: ['', Validators.required],
      address: ['', [Validators.required]],
      birthday: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      
      //phone number validator might be overkill
      contact: ['', [Validators.required, Validators.pattern('[1-9]\\d{2}[1-9]\\d{6}')]], 
    });
  }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe(params => {
      this.id = params['id'];
    });
    console.log(this.id)
  }

  onSubmit() {
    const editedPatient = {
      id: this.id,
      fullname: this.patientForm.value.fullname,
      gender: this.patientForm.value.gender,
      address: this.patientForm.value.address,
      birthday: this.patientForm.value.birthday,
      email: this.patientForm.value.email,
      contact: this.patientForm.value.contact
    }
    this.patientsService.editPatient(editedPatient)
    console.log("submitted ", editedPatient)
  }
}

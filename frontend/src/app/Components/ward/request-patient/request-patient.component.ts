import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PatientsService } from '../../patients/patients.service';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';


@Component({
  selector: 'app-request-patient',
  templateUrl: './request-patient.component.html',
  styleUrls: ['./request-patient.component.css']
})
export class RequestPatientComponent {
  wardId = null;
  requestPatientAdmissionToWardForm: FormGroup;
  assignablePatients: any[] = [];

  constructor(private route: ActivatedRoute, private patientsService: PatientsService, private builder: FormBuilder) {
    this.requestPatientAdmissionToWardForm = builder.group({
      wardId: '',
      patientId: ['', Validators.required],
      rationale: ['', Validators.required],
      priority: ['', Validators.required],
      localDoctor: ['', Validators.required],
    })
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.wardId = params['id']
    })
    this.requestPatientAdmissionToWardForm.patchValue({ wardId: this.wardId })
    this.assignablePatients = this.patientsService.getPatientsNotAssignedToWard();
  }

  onSubmit(): void {
    console.log("submitted form:", this.requestPatientAdmissionToWardForm.value)
    this.patientsService.assignPatientToWard(this.wardId, this.requestPatientAdmissionToWardForm.get("patientId")?.value, this.requestPatientAdmissionToWardForm.value)
    //some db call or whatever
  }
}

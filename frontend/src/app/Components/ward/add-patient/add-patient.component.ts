import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientsService } from '../../patients/patients.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent {
  wardId = null;
  addPatientToWardForm: FormGroup;
  assignablePatients: any[] = [];

  constructor(private route: ActivatedRoute, private patientsService: PatientsService, private builder: FormBuilder, private router: Router) {
    let patientId;
    this.route.queryParams.subscribe(qParams => {
      patientId = qParams["patientId"]
    })
    this.route.params.subscribe(params => {
      this.wardId = params['id']
    })
    this.addPatientToWardForm = builder.group({
      wardId: this.wardId ?? '',
      patientId: [patientId ?? '', Validators.required],
      localDoctor: ['', Validators.required],
      roomNumber: ['', Validators.required],
      bedNumber: ['', Validators.required],
      privateInsuranceNumber: ''
    })
    console.log(this.addPatientToWardForm)
  }

  ngOnInit(): void {
    this.patientsService.getPatients().subscribe(p => {
      this.assignablePatients = p
    }) 
  }

  onSubmit(): void {
    console.log("submitted form:", this.addPatientToWardForm.value)
    this.patientsService.assignPatientToWard(this.wardId, this.addPatientToWardForm.get("patientId")?.value, this.addPatientToWardForm.value )
    //some db call or whatever
    this.router.navigate(["departments"])
  }

}

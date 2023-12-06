import { Component } from '@angular/core';
import { PatientsService } from '../../patients/patients.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-admit-patient-request',
  templateUrl: './admit-patient-request.component.html',
  styleUrls: ['./admit-patient-request.component.css']
})
export class AdmitPatientRequestComponent {
  wardId = null;
  defaultPatients = [
    {id: 1, localDoctor: "John Doc", priority: 5, rationale: "very sick"},
    {id: 2, localDoctor: "John Doc", priority: 8, rationale: "very sick"},
  ]
  patientAdmissionRequests: any[] = this.defaultPatients;
  constructor(private route: ActivatedRoute, private patientsService: PatientsService, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.wardId = params['id']
    })
    this.patientsService.getPatientAdmissionRequestsFromWard(this.wardId).subscribe(admissionReqs => {
      this.patientAdmissionRequests = admissionReqs
    });
  }

  admitPatient(patientId: any): void {
    this.router.navigate(['departments', 'add-patient', this.wardId], { queryParams: { patientId: patientId } })
  }
}

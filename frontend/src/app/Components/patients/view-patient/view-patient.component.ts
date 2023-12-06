import { Component } from '@angular/core';
import { PatientsService } from '../patients.service';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-view-patient',
  templateUrl: './view-patient.component.html',
  styleUrls: ['./view-patient.component.css']
})
export class ViewPatientComponent {
  id: any = null
  patient: any = null
  prescriptions: any[] = []
  constructor(private patientsService: PatientsService, private route: ActivatedRoute) { }

  async ngOnInit(): Promise<void> {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });
    this.loadPatient()
    this.prescriptions = this.patientsService.getPatientPrescriptions(this.id)
  }

  loadPatient(): void {
    this.patientsService.getPatients().subscribe(patients => {
      this.patient = patients.find(patient => patient.id == this.id)
    })
    // this.patientsService.getPatientById(this.id)
  }
}

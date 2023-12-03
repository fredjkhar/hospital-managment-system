import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl} from '@angular/forms';
import { StaffService } from '../../staff/staff.service';
import { PatientsService } from '../../patients/patients.service';

@Component({
  selector: 'app-add-prescription',
  templateUrl: './add-prescription.component.html',
  styleUrls: ['./add-prescription.component.css']
})
export class AddPrescriptionComponent {
  addPrescriptionForm: FormGroup;
  patients: Array<any> = [];
  patientIdSelectorClicked: boolean = false;

  constructor(private builder: FormBuilder, private staffService: StaffService, private patientsService: PatientsService) {
    this.addPrescriptionForm = this.builder.group({
      patientId: ['', [Validators.required, Validators.min(0)]],
      drugNumber: ['', [Validators.required, Validators.pattern("[1-9][0-9]*")]],
      drugName: ['', [Validators.required, Validators.pattern("[a-zA-Z ]*")]],
      unitsPerDay: ['', [Validators.required, Validators.pattern("[1-9][0-9]*\.?[0-9]*")]],
      administrationNbrPerDay: ['', [Validators.required, Validators.pattern("[0-9]*")]],
      administrationMethod: ['', [Validators.required, Validators.pattern("[a-zA-Z ]*")]],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
    });
  }

get patientId() : AbstractControl<string> { return <AbstractControl>this.addPrescriptionForm.get('patientId'); }
get drugNumber() : AbstractControl<string> { return <AbstractControl>this.addPrescriptionForm.get('drugNumber'); }
get drugName() : AbstractControl<string> { return <AbstractControl>this.addPrescriptionForm.get('drugName'); }
get unitsPerDay() : AbstractControl<string> { return <AbstractControl>this.addPrescriptionForm.get('unitsPerDay'); }
get administrationNbrPerDay() : AbstractControl<string> { return <AbstractControl>this.addPrescriptionForm.get('administrationNbrPerDay'); }
get administrationMethod() : AbstractControl<string> { return <AbstractControl>this.addPrescriptionForm.get('administrationMethod'); }
get startDate() : AbstractControl<string> { return <AbstractControl>this.addPrescriptionForm.get('startDate'); }
get endDate() : AbstractControl<string> { return <AbstractControl>this.addPrescriptionForm.get('endDate'); }

  ngOnInit(): void {
    this.patients = this.patientsService.getPatients()
  }

  onSubmit() {
    if (this.addPrescriptionForm.valid) {
      const formData = this.addPrescriptionForm.value;
  
      this.patientsService.addPrescription(formData)
    }
  }

  patientIdSelectorWasClicked(): void {
    this.patientIdSelectorClicked = true
  }
}

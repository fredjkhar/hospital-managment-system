import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-prescription',
  templateUrl: './prescription.component.html',
  styleUrls: ['./prescription.component.css']
})
export class PrescriptionComponent {
  searchText: string = '';
  placeholderPrescriptions = [
    { id: '1', patientId: '1', drugNumber: '1', drugName: 'Tylenol', unitsPerDay: 5, administrationNbrPerDay: 5, administrationMethod: 'IV', startDate: '2022-01-01', endDate: '2023-01-01' },
    { id: '2', patientId: '2', drugNumber: '2', drugName: 'Adderall', unitsPerDay: 10, administrationNbrPerDay: 2, administrationMethod: 'Pills', startDate: '2022-04-01', endDate: '2023-04-01' },
  ];
  prescriptions: any[] = []
  hasSearchResults: boolean = true;

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.loadPrescriptions();
  }

  //might be unnecessary if we subscribe via a service
  private loadPrescriptions(): void {
    this.prescriptions = [...this.placeholderPrescriptions];
  }

  search(): void {
    console.log('Search called', this.searchText);
    let sanitizedSearchText = this.searchText.trim().toLowerCase();
    if (sanitizedSearchText === '') {
      this.loadPrescriptions();
    } else {
      this.prescriptions = this.prescriptions.filter(item => {
        return (
          item.id.includes(sanitizedSearchText) ||
          item.patientId.includes(sanitizedSearchText) ||
          item.drugNumber.includes(sanitizedSearchText) ||
          item.drugName.toLowerCase().includes(sanitizedSearchText) ||
          item.administrationMethod.toLowerCase().includes(sanitizedSearchText) ||
          this.dateComparison(item.startDate, sanitizedSearchText) ||
          this.dateComparison(item.endDate, sanitizedSearchText)
        );
      });
    }
    this.hasSearchResults = this.prescriptions.length > 0;
  }

  openAddPrescriptionForm(): void {
    this.router.navigate(['prescriptions','add-prescription']);
  }

  dateComparison(date: string, compareTo: string): boolean {
    return date.split("-").includes(compareTo)
  }
}

import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
    selector: 'app-nurse-details-dialog',
    template: `
      <h2>Nurse Details</h2>
      <p>Name: {{ data.name }}</p>
      <p>Telephone Extension: {{ data.telExt }}</p>
      <p>Bipper Extension: {{ data.bipExt }}</p>
      <p>Department: {{ data.dept }}</p>
    `,
  })
  export class NurseDialogComponent {
    constructor(@Inject(MAT_DIALOG_DATA) public data: any) {}
}
  
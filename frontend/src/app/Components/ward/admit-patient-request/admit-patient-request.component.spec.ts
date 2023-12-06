import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmitPatientRequestComponent } from './admit-patient-request.component';

describe('AdmitPatientRequestComponent', () => {
  let component: AdmitPatientRequestComponent;
  let fixture: ComponentFixture<AdmitPatientRequestComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdmitPatientRequestComponent]
    });
    fixture = TestBed.createComponent(AdmitPatientRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

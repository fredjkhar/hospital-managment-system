import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DischargePatientComponent } from './discharge-patient.component';

describe('DischargePatientComponent', () => {
  let component: DischargePatientComponent;
  let fixture: ComponentFixture<DischargePatientComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DischargePatientComponent]
    });
    fixture = TestBed.createComponent(DischargePatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

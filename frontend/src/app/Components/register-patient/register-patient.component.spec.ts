import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterPatientComponent } from './register-patient.component';

describe('RegisterPatientComponent', () => {
  let component: RegisterPatientComponent;
  let fixture: ComponentFixture<RegisterPatientComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterPatientComponent]
    });
    fixture = TestBed.createComponent(RegisterPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

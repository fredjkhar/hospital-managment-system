import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestPatientComponent } from './request-patient.component';

describe('RequestPatientComponent', () => {
  let component: RequestPatientComponent;
  let fixture: ComponentFixture<RequestPatientComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RequestPatientComponent]
    });
    fixture = TestBed.createComponent(RequestPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

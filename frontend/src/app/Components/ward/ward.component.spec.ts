import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WardComponent } from './ward.component';

describe('WardComponent', () => {
  let component: WardComponent;
  let fixture: ComponentFixture<WardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WardComponent]
    });
    fixture = TestBed.createComponent(WardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

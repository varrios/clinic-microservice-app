import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorEditComponent } from './doctor-create.component';

describe('AppointmentEditComponent', () => {
  let component: DoctorEditComponent;
  let fixture: ComponentFixture<DoctorEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DoctorEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoctorEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

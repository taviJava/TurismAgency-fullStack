import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TripParticipantsComponent } from './trip-participants.component';

describe('TripParticipantsComponent', () => {
  let component: TripParticipantsComponent;
  let fixture: ComponentFixture<TripParticipantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TripParticipantsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TripParticipantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

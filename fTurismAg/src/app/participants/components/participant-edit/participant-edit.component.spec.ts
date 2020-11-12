import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParticipantEditComponent } from './participant-edit.component';

describe('ParticipantEditComponent', () => {
  let component: ParticipantEditComponent;
  let fixture: ComponentFixture<ParticipantEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParticipantEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ParticipantEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

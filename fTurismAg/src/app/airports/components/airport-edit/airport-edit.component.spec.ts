import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AirportEditComponent } from './airport-edit.component';

describe('AirportEditComponent', () => {
  let component: AirportEditComponent;
  let fixture: ComponentFixture<AirportEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AirportEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AirportEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

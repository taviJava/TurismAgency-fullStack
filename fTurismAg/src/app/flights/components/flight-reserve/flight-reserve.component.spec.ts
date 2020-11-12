import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightReserveComponent } from './flight-reserve.component';

describe('FlightReserveComponent', () => {
  let component: FlightReserveComponent;
  let fixture: ComponentFixture<FlightReserveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlightReserveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightReserveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

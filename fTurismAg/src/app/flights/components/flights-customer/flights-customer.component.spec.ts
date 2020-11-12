import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightsCustomerComponent } from './flights-customer.component';

describe('FlightsCustomerComponent', () => {
  let component: FlightsCustomerComponent;
  let fixture: ComponentFixture<FlightsCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlightsCustomerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightsCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

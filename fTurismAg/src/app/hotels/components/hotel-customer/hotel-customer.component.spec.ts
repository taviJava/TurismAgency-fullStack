import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelCustomerComponent } from './hotel-customer.component';

describe('HotelCustomerComponent', () => {
  let component: HotelCustomerComponent;
  let fixture: ComponentFixture<HotelCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelCustomerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

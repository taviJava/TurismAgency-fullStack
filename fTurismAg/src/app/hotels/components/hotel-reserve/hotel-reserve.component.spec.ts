import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelReserveComponent } from './hotel-reserve.component';

describe('HotelReserveComponent', () => {
  let component: HotelReserveComponent;
  let fixture: ComponentFixture<HotelReserveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelReserveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelReserveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelsCustomerViewComponent } from './hotels-customer-view.component';

describe('HotelsCustomerViewComponent', () => {
  let component: HotelsCustomerViewComponent;
  let fixture: ComponentFixture<HotelsCustomerViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelsCustomerViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelsCustomerViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

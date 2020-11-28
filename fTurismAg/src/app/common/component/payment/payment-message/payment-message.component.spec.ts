import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentMessageComponent } from './payment-message.component';

describe('PaymentMessageComponent', () => {
  let component: PaymentMessageComponent;
  let fixture: ComponentFixture<PaymentMessageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaymentMessageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymentMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AirportAddComponent } from './airport-add.component';

describe('AirportAddComponent', () => {
  let component: AirportAddComponent;
  let fixture: ComponentFixture<AirportAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AirportAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AirportAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CityCountryComponent } from './city-country.component';

describe('CityCountryComponent', () => {
  let component: CityCountryComponent;
  let fixture: ComponentFixture<CityCountryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CityCountryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CityCountryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

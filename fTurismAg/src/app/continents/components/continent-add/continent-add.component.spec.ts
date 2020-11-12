import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContinentAddComponent } from './continent-add.component';

describe('ContinentAddComponent', () => {
  let component: ContinentAddComponent;
  let fixture: ComponentFixture<ContinentAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContinentAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContinentAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

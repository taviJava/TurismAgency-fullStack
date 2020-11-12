import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContinentEditComponent } from './continent-edit.component';

describe('ContinentEditComponent', () => {
  let component: ContinentEditComponent;
  let fixture: ComponentFixture<ContinentEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContinentEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContinentEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

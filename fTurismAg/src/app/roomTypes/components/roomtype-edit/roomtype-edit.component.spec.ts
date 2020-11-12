import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomtypeEditComponent } from './roomtype-edit.component';

describe('RoomtypeEditComponent', () => {
  let component: RoomtypeEditComponent;
  let fixture: ComponentFixture<RoomtypeEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RoomtypeEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RoomtypeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

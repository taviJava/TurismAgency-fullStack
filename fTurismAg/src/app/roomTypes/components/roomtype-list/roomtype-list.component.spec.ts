import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomtypeListComponent } from './roomtype-list.component';

describe('RoomtypeListComponent', () => {
  let component: RoomtypeListComponent;
  let fixture: ComponentFixture<RoomtypeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RoomtypeListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RoomtypeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

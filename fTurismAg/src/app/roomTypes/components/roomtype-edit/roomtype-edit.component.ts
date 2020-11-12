import {Component, OnInit} from '@angular/core';
import {RoomType} from '../../model/room-type';
import {ActivatedRoute, Router} from '@angular/router';
import {RoomTypeService} from '../../services/room-type.service';

@Component({
  selector: 'app-roomtype-edit',
  templateUrl: './roomtype-edit.component.html',
  styleUrls: ['./roomtype-edit.component.css']
})
export class RoomtypeEditComponent implements OnInit {
  roomType: RoomType;
  id: number;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private roomTypeService: RoomTypeService) {
  }

  ngOnInit(): void {
    this.roomType = new RoomType();
    this.id = this.route.snapshot.params.id;
    this.roomTypeService.getById(this.id).subscribe(data => {
      this.roomType = data;
    });
  }
  // tslint:disable-next-line:typedef
  gotoRoomTypeList() {
    this.router.navigate(['/roomType']);
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    this.roomTypeService.update(this.roomType).subscribe(result => this.gotoRoomTypeList());
  }
}

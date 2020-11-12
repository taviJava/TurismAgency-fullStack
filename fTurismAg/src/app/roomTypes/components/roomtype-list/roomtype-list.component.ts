import {Component, OnInit} from '@angular/core';

import {ActivatedRoute, Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {RoomTypeService} from '../../services/room-type.service';
import {RoomType} from '../../model/room-type';

@Component({
  selector: 'app-roomtype-list',
  templateUrl: './roomtype-list.component.html',
  styleUrls: ['./roomtype-list.component.css']
})
export class RoomtypeListComponent implements OnInit {
  roomType: RoomType[];
  closeResult = '';
  searchValue = '';
  constructor(private roomTypeService: RoomTypeService,
              private route: ActivatedRoute,
              private router: Router,
              private modalService: NgbModal) {
  }

  ngOnInit(): void {
    this.getRoomType();
  }

  // tslint:disable-next-line:typedef
  getRoomType() {
    this.roomTypeService.findAll().subscribe(data => {
      this.roomType = data;
    });
  }

  // tslint:disable-next-line:typedef
  addRoomType() {
    this.router.navigate(['addRoomType']);
  }

  // tslint:disable-next-line:typedef
  editRoomType(id: number) {
    this.router.navigate(['editRoomType/' + id]);
  }

  // tslint:disable-next-line:typedef
  deleteRoomType(id: number) {
    this.roomTypeService.delete(id).subscribe(data => {
      this.getRoomType();
    });
  }
}

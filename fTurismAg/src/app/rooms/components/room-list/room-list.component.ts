import {Component, OnInit} from '@angular/core';
import {Room} from '../../model/room';

import {ActivatedRoute, Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {RoomService} from '../../services/room.service';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {
  room: Room[];
  searchValue = '';
  id: number;

  constructor(private roomService: RoomService,
              private route: ActivatedRoute,
              private router: Router,
              private modalService: NgbModal) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    this.getRoom();
  }

  // tslint:disable-next-line:typedef
  getRoom() {
    this.roomService.findAll(this.id).subscribe(data => {
      this.room = data;
    });
  }

  // tslint:disable-next-line:typedef
  addRoom() {
    this.router.navigate(['addRooms/' + this.id]);
  }

  // tslint:disable-next-line:typedef
  editRoom(id: number) {
    this.router.navigate(['editRoom/' + id]);
  }

  // tslint:disable-next-line:typedef
  deleteRoom(id: number) {
    this.roomService.delete(id).subscribe(data => {
      this.getRoom();
    });
  }
  ifHasBalcony(room: Room): string {
    if (room.roomTypeModel.hasbalcony) {
      return 'yes';
    }
    return 'no';
  }
}

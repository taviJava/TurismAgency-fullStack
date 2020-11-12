import {Component, OnInit} from '@angular/core';
import {Room} from '../../model/room';
import {ActivatedRoute, Router} from '@angular/router';
import {RoomService} from '../../services/room.service';
import {IDropdownSettings} from 'ng-multiselect-dropdown';
import {RoomType} from '../../../roomTypes/model/room-type';
import {RoomTypeService} from '../../../roomTypes/services/room-type.service';

@Component({
  selector: 'app-room-edit',
  templateUrl: './room-edit.component.html',
  styleUrls: ['./room-edit.component.css']
})
export class RoomEditComponent implements OnInit {
  room: Room;
  id: number;
  dropdownSettings: IDropdownSettings = {};
  roomtypes: RoomType [];
  selectedRoomtypes: RoomType[];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private roomService: RoomService,
              private roomtypeService: RoomTypeService) {
  }

  ngOnInit(): void {
    this.roomtypes = [];
    this.room = new Room();
    this.id = this.route.snapshot.params.id;
    this.roomService.getById(this.id).subscribe(data => {
      this.room = data;
      this.selectedRoomtypes = [];
      this.selectedRoomtypes.push(this.room.roomTypeModel);
    });
    this.roomtypeService.findAll().subscribe(data => this.roomtypes = data);
    this.dropdownSettings = {
      singleSelection: true,
      idField: 'id',
      textField: 'name',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
  }

// tslint:disable-next-line:typedef
  getRoomList() {
    this.router.navigate(['/room']);
  }

// tslint:disable-next-line:typedef
  onSubmit() {
    this.room.roomTypeModel = this.selectedRoomtypes[0];
    this.roomService.update(this.room).subscribe(result => this.getRoomList());
  }

  // tslint:disable-next-line:typedef
  onItemSelect(item: any) {
    console.log(item);
  }

  // tslint:disable-next-line:typedef
  onSelectAll(items: any) {
    console.log(items);
  }
}

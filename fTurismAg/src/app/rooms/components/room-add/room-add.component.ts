import {Component, OnInit} from '@angular/core';
import {Room} from '../../model/room';
import {ActivatedRoute, Router} from '@angular/router';

import {RoomService} from '../../services/room.service';
import {IDropdownSettings} from 'ng-multiselect-dropdown';
import {RoomType} from '../../../roomTypes/model/room-type';
import {RoomTypeService} from '../../../roomTypes/services/room-type.service';

@Component({
  selector: 'app-room-add',
  templateUrl: './room-add.component.html',
  styleUrls: ['./room-add.component.css']
})
export class RoomAddComponent implements OnInit {
  dropdownSettings: IDropdownSettings = {};
  roomtypes: RoomType[];
  selectedRoomtypes: RoomType[] = [];
  id: number;
  numRooms: number;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private roomService: RoomService,
              private roomTypeService: RoomTypeService) {
  }

  ngOnInit(): void {
    this.roomtypes = [];
    this.roomTypeService.findAll().subscribe(data => this.roomtypes = data);
    this.dropdownSettings = {
      singleSelection: true,
      idField: 'id',
      textField: 'name',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
    this.id = this.route.snapshot.params.idH;
  }

// tslint:disable-next-line:typedef
  getRoomList() {
    this.router.navigate(['room/' + this.id]);
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    this.roomService.save(this.selectedRoomtypes[0].id, this.id, this.numRooms).subscribe(result => this.getRoomList());
  }
  // tslint:disable-next-line:typedef
  onItemSelect(item: any) {
    console.log(item);
  }

  // tslint:disable-next-line:typedef
  onSelectAll(items: any) {
    console.log(items);
  }
  ifFormIsCompleted(): boolean{
    if (this.selectedRoomtypes.length > 0 && this.numRooms !== null){
      return true;
    }
    return false;
  }
}

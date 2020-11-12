import { Component, OnInit } from '@angular/core';
import {RoomType} from '../../model/room-type';
import {ActivatedRoute, Router} from '@angular/router';
import {RoomTypeService} from '../../services/room-type.service';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-roomtype-add',
  templateUrl: './roomtype-add.component.html',
  styleUrls: ['./roomtype-add.component.css']
})
export class RoomtypeAddComponent implements OnInit {
roomType: RoomType = new RoomType();
words: string[] = ['no' , 'yes'];
balcony = 'no';
myGroup: FormGroup;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private roomTypeService: RoomTypeService) { }

  ngOnInit(): void {
    this.myGroup = new FormGroup({
      name: new FormControl(this.balcony)
    });
  }
// tslint:disable-next-line:typedef
  getRoomTypeList() {
    this.router.navigate(['roomType']);
  }
  // tslint:disable-next-line:typedef
  onSubmit(){
    this.roomType.hasbalcony = this.hasBalcony();
    this.roomTypeService.save(this.roomType).subscribe(result => this.getRoomTypeList());
  }
  hasBalcony(): boolean{
    if (this.balcony === 'yes'){
      return true;
    }
    return false;
  }
}

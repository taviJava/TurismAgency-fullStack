import {Component, OnInit} from '@angular/core';
import {Hotel} from '../../model/hotel';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';
import {HotelService} from '../../service/hotel.service';
import {IDropdownSettings} from 'ng-multiselect-dropdown';
import {Country} from '../../../countries/model/country';
import {City} from '../../../cities/model/city';
import {CityService} from '../../../cities/service/city.service';

@Component({
  selector: 'app-hotel-edit',
  templateUrl: './hotel-edit.component.html',
  styleUrls: ['./hotel-edit.component.css']
})
export class HotelEditComponent implements OnInit {

  hotel: Hotel;
  id: number;
  dropdownSettings: IDropdownSettings = {};
  cities: City[];
  selectedCity: City[];

  constructor(private hotelService: HotelService,
              private cityService: CityService,
              private router: Router,
              private route: ActivatedRoute,
  ) {
  }

  ngOnInit(): void {
    this.hotel = new Hotel();
    this.cities = [];
    this.selectedCity = [];
    this.id = this.route.snapshot.params.id;
    this.hotelService.getById(this.id).subscribe(data => {
      this.hotel = new Hotel();
      this.selectedCity = [];
      this.hotel = data;
      this.selectedCity.push(this.hotel.cityModel);
    });
    this.cityService.findAll().subscribe(data => this.cities = data);
    this.dropdownSettings = {
      singleSelection: true,
      idField: 'id',
      textField: 'name',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true,
    };
  }


  // tslint:disable-next-line:typedef
  onSubmit() {
    this.hotel.cityModel = this.selectedCity[0];
    this.hotelService.update(this.hotel).subscribe(result => this.goToHotelList());
  }

  // tslint:disable-next-line:typedef
  goToHotelList() {
    this.router.navigate(['/hotels']);
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

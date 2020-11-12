import { Component, OnInit } from '@angular/core';
import {City} from '../../model/city';
import {ActivatedRoute, Router} from '@angular/router';
import {CountryService} from '../../../countries/service/country.service';
import {CityService} from '../../service/city.service';
import {IDropdownSettings} from 'ng-multiselect-dropdown';
import {Country} from '../../../countries/model/country';

@Component({
  selector: 'app-city-add',
  templateUrl: './city-add.component.html',
  styleUrls: ['./city-add.component.css']
})
export class CityAddComponent implements OnInit {
  city: City;
  dropdownSettings: IDropdownSettings = {};
  countries: Country[];
  selectedCountry: Country[];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private countryService: CountryService,
              private cityService: CityService
  ) {
  }

  ngOnInit(): void {
    this.city = new City();
    this.countries = [];
    this.selectedCountry = [];
    this.countryService.findAll().subscribe(data => this.countries = data);
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
  gotoCitiesList() {
    this.router.navigate(['cities']);
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    this.city.countryModel = this.selectedCountry[0];
    this.cityService.save(this.city).subscribe(result => this.gotoCitiesList());
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

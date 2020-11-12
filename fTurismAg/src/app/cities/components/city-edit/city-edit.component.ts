import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {IDropdownSettings} from 'ng-multiselect-dropdown';
import {City} from '../../model/city';
import {CityService} from '../../service/city.service';
import {Country} from '../../../countries/model/country';
import {CountryService} from '../../../countries/service/country.service';

@Component({
  selector: 'app-city-edit',
  templateUrl: './city-edit.component.html',
  styleUrls: ['./city-edit.component.css']
})
export class CityEditComponent implements OnInit {
  city: City;
  id: number;
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
    this.id = this.route.snapshot.params.id;
    this.cityService.getById(this.id).subscribe(data => {
      this.city = new City();
      this.selectedCountry = [];
      this.city = data;
      this.selectedCountry.push(this.city.countryModel);
    });
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
    this.cityService.update(this.city).subscribe(result => this.gotoCitiesList());
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

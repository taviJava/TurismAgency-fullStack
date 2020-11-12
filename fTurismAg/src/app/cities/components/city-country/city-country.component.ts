import {Component, OnInit} from '@angular/core';
import {IDropdownSettings} from 'ng-multiselect-dropdown';
import {FormControl, FormGroup} from '@angular/forms';
import {City} from '../../model/city';
import {Country} from '../../../countries/model/country';
import {ActivatedRoute, Router} from '@angular/router';
import {CityService} from '../../service/city.service';
import {CountryService} from '../../../countries/service/country.service';

@Component({
  selector: 'app-city-country',
  templateUrl: './city-country.component.html',
  styleUrls: ['./city-country.component.css']
})
export class CityCountryComponent implements OnInit {
  dropdownSettings: IDropdownSettings = {};
  myGroup: FormGroup;
  city: City;
  cities: City[];
  countries: Country[];
  countries2: Country[] = [];
  id: number;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private cityService: CityService,
              private  countryService: CountryService) {
  }

  ngOnInit(): void {
    this.city = new City();
    this.countries = [];
    this.cities = [];
    this.getCities();
    console.log(this.cities[0]);
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
    this.myGroup = new FormGroup({
      continentModel: new FormControl()
    });
  }
// tslint:disable-next-line:typedef
getCities(){
    this.cityService.findAll().subscribe( data => this.cities = data);
}
// tslint:disable-next-line:typedef
getCitiesList(){
    this.router.navigate(['cities']);
}
// tslint:disable-next-line:typedef
onSubmit(city: City){
    this.countries2 = this.myGroup.get('countryModel').value;
    city.countryModel = this.countries2[0];
    this.cityService.save(city).subscribe(this.getCitiesList);
}
  // tslint:disable-next-line:typedef
  onItemSelect(item: any) {
    console.log(item);
  }
  // tslint:disable-next-line:typedef
  onSelectAll(items: any) {
    console.log(items);
  }
  getPlaceHolder(city: City): string{
    return 'Select the country for the city: ' + city.name;
  }
}

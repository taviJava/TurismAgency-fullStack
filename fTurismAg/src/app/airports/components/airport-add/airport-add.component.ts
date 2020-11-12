import {Component, OnInit} from '@angular/core';
import {Airport} from '../../model/airport';
import {AirportService} from '../../service/airport.service';
import {ActivatedRoute, Router} from '@angular/router';
import {IDropdownSettings} from 'ng-multiselect-dropdown';
import {Country} from '../../../countries/model/country';
import {City} from '../../../cities/model/city';
import {CityService} from '../../../cities/service/city.service';

@Component({
  selector: 'app-airport-add',
  templateUrl: './airport-add.component.html',
  styleUrls: ['./airport-add.component.css']
})
export class AirportAddComponent implements OnInit {
  airport: Airport;
  dropdownSettings: IDropdownSettings = {};
  allCities: City[];
  cities: City[];
  selectedCity: City[];

  constructor(
    private airportService: AirportService,
    private route: ActivatedRoute,
    private router: Router,
    private cityService: CityService) {
  }

  ngOnInit(): void {
    this.airport = new Airport();
    this.cities = [];
    this.selectedCity = [];
    this.cityService.findAll().subscribe(data => {
      this.allCities = [];
      this.allCities = data;
      this.cities = [];
      for (const city of this.allCities){
        if (city.airportModel === null){
          this.cities.push(city);
        }
      }
    } );
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
  goToAirportList() {
    this.router.navigate(['airports']);
  }

// tslint:disable-next-line:typedef
  onSubmit() {
    this.airport.cityModel = this.selectedCity[0];
    console.log(this.airport);
    this.airportService.save(this.airport).subscribe(result => this.goToAirportList());
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

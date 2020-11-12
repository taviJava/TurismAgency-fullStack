import { Component, OnInit } from '@angular/core';
import {Airport} from '../../model/airport';
import {ActivatedRoute, Router} from '@angular/router';
import {AirportService} from '../../service/airport.service';
import {CityService} from '../../../cities/service/city.service';
import {IDropdownSettings} from 'ng-multiselect-dropdown';
import {City} from '../../../cities/model/city';

@Component({
  selector: 'app-airport-edit',
  templateUrl: './airport-edit.component.html',
  styleUrls: ['./airport-edit.component.css']
})
export class AirportEditComponent implements OnInit {
  airport: Airport;
  id: number;
  dropdownSettings: IDropdownSettings = {};
  cities: City[];
  selectedCity: City[];
  allCities: City[];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private airportService: AirportService,
              private cityService: CityService) { }

  ngOnInit(): void {
    this.airport = new Airport();
    this.cities = [];
    this.selectedCity = [];
    this.id = this.route.snapshot.params.id;
    this.airportService.getById(this.id).subscribe(data => {
      this.airport = new Airport();
      this.selectedCity = [];
      this.airport = data;
      this.selectedCity.push(this.airport.cityModel);
    });
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
  onSubmit() {
    this.airport.cityModel = this.selectedCity[0];
    this.airportService.save(this.airport).subscribe(result => this.goToAirportList());
  }

  // tslint:disable-next-line:typedef
  goToAirportList() {
    this.router.navigate(['airports']);
  }// tslint:disable-next-line:typedef
  onItemSelect(item: any) {
    console.log(item);
  }

  // tslint:disable-next-line:typedef
  onSelectAll(items: any) {
    console.log(items);
  }
}

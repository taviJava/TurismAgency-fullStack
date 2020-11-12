import { Component, OnInit } from '@angular/core';
import {Country} from '../../model/country';
import {CountryService} from '../../service/country.service';
import {ActivatedRoute, Router} from '@angular/router';
import {IDropdownSettings} from 'ng-multiselect-dropdown';
import {Continent} from '../../../continents/model/continent';
import {ContinentService} from '../../../continents/service/continent.service';

@Component({
  selector: 'app-country-add',
  templateUrl: './country-add.component.html',
  styleUrls: ['./country-add.component.css']
})
export class CountryAddComponent implements OnInit {
  country: Country = new Country();
  dropdownSettings: IDropdownSettings = {};
  continents: Continent[];
  selectedContinets: Continent[] = [];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private countryService: CountryService,
              private continentService: ContinentService
  ) {
  }

  ngOnInit(): void {
    this.continents = [];
    this.continentService.findAll().subscribe(data => this.continents = data);
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
  gotoCountriesList() {
    this.router.navigate(['countries']);
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    this.country.continentModel = this.selectedContinets[0];
    this.countryService.save(this.country).subscribe(result => this.gotoCountriesList());
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

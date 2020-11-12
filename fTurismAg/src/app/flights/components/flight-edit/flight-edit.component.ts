import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Flight} from '../../model/flight';
import {FlightService} from '../../service/flight.service';
import {IDropdownSettings} from 'ng-multiselect-dropdown';
import {City} from '../../../cities/model/city';
import {Airport} from '../../../airports/model/airport';
import {AirportService} from '../../../airports/service/airport.service';
import {Hotel} from '../../../hotels/model/hotel';

@Component({
  selector: 'app-flight-edit',
  templateUrl: './flight-edit.component.html',
  styleUrls: ['./flight-edit.component.css']
})
export class FlightEditComponent implements OnInit {

  flight: Flight;
  id: number;
  dropdownSettings: IDropdownSettings = {};
  airports: Airport[];
  selectedAirportsDep: Airport[];
  selectedAirportsArr: Airport[];


  constructor(private flightService: FlightService,
              private airportService: AirportService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.flight = new Flight();
    this.airports = [];
    this.selectedAirportsDep = [];
    this.selectedAirportsArr = [];
    this.id = this.route.snapshot.params.id;
    this.flightService.getById(this.id).subscribe(data => {
      this.flight = new Flight();
      this.selectedAirportsDep = [];
      this.selectedAirportsArr = [];
      this.flight = data;
      this.selectedAirportsDep.push(this.flight.airportDeparture);
      this.selectedAirportsArr.push(this.flight.airportArrival);
    });
    this.airportService.findAll().subscribe(data => this.airports = data);
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
    this.flight.airportDeparture = this.selectedAirportsDep[0];
    this.flight.airportArrival = this.selectedAirportsArr[0];
    this.flightService.update(this.flight).subscribe(result => this.goToFlightList());
  }

  // tslint:disable-next-line:typedef
  goToFlightList() {
    this.router.navigate(['/flights']);
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

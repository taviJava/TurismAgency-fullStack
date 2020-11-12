import { Component, OnInit } from '@angular/core';
import {Flight} from '../../model/flight';
import {FlightService} from '../../service/flight.service';
import {ActivatedRoute, Router} from '@angular/router';
import {IDropdownSettings} from 'ng-multiselect-dropdown';
import {City} from '../../../cities/model/city';
import {Airport} from '../../../airports/model/airport';
import {AirportService} from '../../../airports/service/airport.service';
import {Hotel} from '../../../hotels/model/hotel';
import {NgbDateStruct, NgbTimeStruct} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-flight-form',
  templateUrl: './flight-form.component.html',
  styleUrls: ['./flight-form.component.css']
})
export class FlightFormComponent implements OnInit {

  flight: Flight;
  dropdownSettings: IDropdownSettings = {};
  airports: Airport[];
  selectedAirportsDep: Airport[];
  selectedAirportsArr: Airport[];
  dateIn: NgbDateStruct;
  dateOut: NgbDateStruct;
  timeIn: NgbTimeStruct;
  timeEnd: NgbTimeStruct;
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
  onSubmit(){
    this.createDateTime();
    this.flight.airportDeparture = this.selectedAirportsDep[0];
    this.flight.airportArrival = this.selectedAirportsArr[0];
    if (this.ifFormCompleted()){
      this.flightService.save(this.flight).subscribe(result => this.goToFlightList());
    }
  }

  // tslint:disable-next-line:typedef
  goToFlightList(){
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
  ifFormCompleted(): boolean{
    if (this.selectedAirportsDep !== null && this.selectedAirportsArr !== null && this.flight.departureDay !== null
    && this.flight.returnDay !== null && this.flight.departureHour !== null && this.flight.arriveHour !== null && this.flight.name !== null
    && this.flight.rowsNumber !== null && this.flight.seatsRowNumber !== null){
      return true;
    }
    return false;
  }
  // tslint:disable-next-line:typedef
  createDateTime(){
    let month1 = '';
    let month2 = '';
    let day1 = '';
    let day2 = '';
    let hour1 = '';
    let hour2 = '';
    let min1 = '';
    let min2 = '';
    if (this.dateIn.month < 10){
      month1 = '0' + this.dateIn.month;
    }else{
      month1 = '' + this.dateIn.month;
    }
    if (this.dateOut.month < 10){
      month2 = '0' + this.dateOut.month;
    }else {
      month2 = '' + this.dateOut.month;
    }
    if (this.dateIn.day < 10){
      day1 = '0' + (this.dateIn.day + 1);
    }else{
      day1 = '' + (this.dateIn.day + 1);
    }
    if (this.dateOut.day < 10){
      day2 = '0' + (this.dateOut.day + 1);
    }else{
      day2 = '' + (this.dateOut.day + 1);
    }
    if (this.timeIn.hour < 10){
      hour1 = '0' + this.timeIn.hour;
    }else {
      hour1 = '' + this.timeIn.hour;
    }
    if (this.timeEnd.hour < 10){
      hour2 = '0' + this.timeEnd.hour;
    }else {
      hour2 = '' + this.timeEnd.hour;
    }
    if (this.timeIn.minute < 10){
      min1 = '0' + this.timeIn.minute;
    }else {
      min1 = '' + this.timeIn.minute;
    }
    if (this.timeEnd.minute < 10){
      min2 = '0' + this.timeEnd.minute;
    }else {
      min2 = '' + this.timeEnd.minute;
    }
    this.flight.departureDay = this.dateIn.year + '-' + month1 + '-' + day1;
    this.flight.returnDay = this.dateOut.year + '-' + month2 + '-' + day2;
    this.flight.departureHour = hour1 + ':' + min1 + ':' + '00';
    this.flight.arriveHour = hour2 + ':' + min2 + ':' + '00';
  }

}

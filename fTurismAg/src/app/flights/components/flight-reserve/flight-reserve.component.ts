import { Component, OnInit } from '@angular/core';
import {Flight} from '../../model/flight';
import {ActivatedRoute, Router} from '@angular/router';
import {FlightService} from '../../service/flight.service';
import * as $ from 'jquery';
import {Seat} from '../../model/seat';
import {Reservationf} from '../../model/reservationf';





@Component({
  selector: 'app-flight-reserve',
  templateUrl: './flight-reserve.component.html',
  styleUrls: ['./flight-reserve.component.css']
})
export class FlightReserveComponent implements OnInit {
  flight: Flight = new Flight();
  id: number;
  seatsL: Seat[] = [];
  seatsR: Seat[] = [];
  numberOfSeatsStyle: number;

  constructor(private router: Router,
              private flightService: FlightService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.flight = new Flight();
    this.id = this.route.snapshot.params.id;
    this.flightService.getById(this.id).subscribe(data => {
      this.flight = new Flight();
      this.flight = data;
      this.numberOfSeatsStyle = (12 / this.flight.seatsRowNumber);
    });
    this.flightService.getSeatsLeft(this.id).subscribe(data => {
      this.seatsL = [];
      this.seatsL = data;
    });
    this.flightService.getSeatsRight(this.id).subscribe(data => {
      this.seatsR = [];
      this.seatsR = data;
    });
}
// tslint:disable-next-line:typedef
hideSeat(seat: Seat, event){
  $('.seat').on('click', function(): void {
    $(this).toggleClass('active');
  });
  setTimeout(() =>
    {
      if (this.ifSelected(event)){
       // seat.reservation.date = this.flight.departureDay;
        console.log(seat);
      }
      if (!this.ifSelected(event)){
      //  seat.reservation = null;
        console.log('test');
      }
    },
    3000);

}

// tslint:disable-next-line:typedef
test(){
    console.log('test');
}


// tslint:disable-next-line:typedef
ifSelected(event): boolean{
    if ( $(event).hasClass('active')){
      return true;
    }
}



// tslint:disable-next-line:typedef
ifIsReserved(seat: Seat){
  $('label').on('click', function(): void {
    if (!$(this).hasClass('reserved')) {
      if ($(this).find('input').is(':checked')) {
        $(this).addClass('selected');
      } else {
        console.log('selected');
        $(this).removeClass('selected');
      }
    } else {
      alert('Already booked');
    }
  });
}
}


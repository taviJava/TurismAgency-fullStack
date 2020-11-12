import { Component, OnInit } from '@angular/core';
import {Trip} from '../../model/trip';
import {ActivatedRoute, Router} from '@angular/router';
import {TripService} from '../../service/trip.service';

@Component({
  selector: 'app-trip-form',
  templateUrl: './trip-form.component.html',
  styleUrls: ['./trip-form.component.css']
})
export class TripFormComponent implements OnInit {

  trip: Trip;
  constructor(private route: ActivatedRoute,
              private router: Router,
              private tripService: TripService) {this.trip = new Trip();
  }

  ngOnInit(): void {
  }
  // tslint:disable-next-line:typedef
  onSubmit(){
    this.tripService.save(this.trip).subscribe(result => {
      this.goToTripList();
    });
  }
  // tslint:disable-next-line:typedef
  goToTripList(){
    this.router.navigate(['/trips']);
  }
}

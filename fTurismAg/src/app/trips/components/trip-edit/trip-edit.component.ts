import { Component, OnInit } from '@angular/core';
import {Trip} from '../../model/trip';
import {ActivatedRoute, Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {TripService} from '../../service/trip.service';

@Component({
  selector: 'app-trip-edit',
  templateUrl: './trip-edit.component.html',
  styleUrls: ['./trip-edit.component.css']
})
export class TripEditComponent implements OnInit {
  trip: Trip;
  id: number;
  constructor(private route: ActivatedRoute,
              private router: Router,
              private tripService: TripService) {this.trip = new Trip();
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    this.tripService.getById(this.id).subscribe(data => {
      this.trip = data;
    });
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

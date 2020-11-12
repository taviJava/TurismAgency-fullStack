import { Component, OnInit } from '@angular/core';
import {Trip} from '../../model/trip';
import {Participant} from '../../../participants/model/participant';
import {ActivatedRoute, Router} from '@angular/router';
import {TripService} from '../../service/trip.service';

@Component({
  selector: 'app-trip-participants',
  templateUrl: './trip-participants.component.html',
  styleUrls: ['./trip-participants.component.css']
})
export class TripParticipantsComponent implements OnInit {

  trip: Trip;
  id: number;
  unParticipants: Participant[];
  selUnParticipants: Participant[];
  selAsParticipants: Participant[];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private tripService: TripService) {
    this.trip = new Trip();
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    this.loadTripData();
  }

  // tslint:disable-next-line:typedef
  loadTripData() {
    this.tripService.getById(this.id).subscribe(data => {
      this.trip = new Trip();
      this.trip = data;
      this.tripService.getUnassignedParticipants(this.trip.id).subscribe(data1 => {
        this.unParticipants = data1;
      });
    });
  }
  // tslint:disable-next-line:typedef
  goToTripList(){
    this.router.navigate(['/trips']);
  }
  // tslint:disable-next-line:typedef
  assignParticipantsToTrip(){
    this.tripService.assignParticipantToTrip(this.trip, this.selUnParticipants).subscribe(data => {
      this.selUnParticipants = null;
      this.loadTripData();
    });
  }
  // tslint:disable-next-line:typedef
  unassignParticipantsFromTrip(){
    this.tripService.unassignParticipantFromTrip(this.trip, this.selAsParticipants).subscribe(data => {
      this.selAsParticipants = null;
      this.loadTripData();
    });
  }
}


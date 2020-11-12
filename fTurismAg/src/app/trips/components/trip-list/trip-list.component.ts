import {Component, OnInit} from '@angular/core';
import {Trip} from '../../model/trip';
import {ActivatedRoute, Router} from '@angular/router';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {TripService} from '../../service/trip.service';

@Component({
  selector: 'app-trip-list',
  templateUrl: './trip-list.component.html',
  styleUrls: ['./trip-list.component.css']
})
export class TripListComponent implements OnInit {
  trips: Trip[];
  closeResult = '';
  searchValue = '';
  p = 1;
  numberOfItemsPerP = 1;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private modalService: NgbModal,
              private tripService: TripService) {
  }

  ngOnInit(): void {
    this.getTrips();
  }

  // tslint:disable-next-line:typedef
  getTrips(){
    this.tripService.findAll().subscribe(data => {this.trips = data; });
  }
  // tslint:disable-next-line:typedef
  addTrip() {
    this.router.navigate(['addTrip']);
  }
  // tslint:disable-next-line:typedef
  edittrip(id: number) {
    this.router.navigate(['editTrip/' + id]);

  }
  // tslint:disable-next-line:typedef
  tripParticipants(id: number){
    this.router.navigate(['tripparticipants/' + id]);
  }
  // tslint:disable-next-line:typedef
  deleteParticipant(id: number){
    this.tripService.delete(id).subscribe(data =>
      this.getTrips());
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  // tslint:disable-next-line:typedef
  open(content, id) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
      this.deleteParticipant(id);
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
}

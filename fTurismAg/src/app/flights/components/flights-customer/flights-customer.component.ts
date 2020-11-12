import { Component, OnInit } from '@angular/core';
import {Flight} from '../../model/flight';
import {FlightService} from '../../service/flight.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-flights-customer',
  templateUrl: './flights-customer.component.html',
  styleUrls: ['./flights-customer.component.css']
})
export class FlightsCustomerComponent implements OnInit {
  flights: Flight[];
  closeResult = '';
  searchValue = '';
  p = 1;
  numberOfItemsPerP = 10;

  constructor(private flightService: FlightService,
              private router: Router,
              private route: ActivatedRoute,
              private modalService: NgbModal) {
  }

  ngOnInit(): void {
    this.getFlights();
  }

  // tslint:disable-next-line:typedef
  public getFlights() {
    return this.flightService.findAll().subscribe(result => {
      this.flights = result;
    });
  }

  // tslint:disable-next-line:typedef
  deleteFlight(id: number) {
    this.flightService.delete(id).subscribe(result => this.getFlights());
  }

  // tslint:disable-next-line:typedef
  addFlight() {
    this.router.navigate(['addFlight']);
  }

  // tslint:disable-next-line:typedef
  editFlight(id: number) {
    this.router.navigate(['editFlight', id]);
  }
  // tslint:disable-next-line:typedef
  open(content, id) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
      this.deleteFlight(id);
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
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
}

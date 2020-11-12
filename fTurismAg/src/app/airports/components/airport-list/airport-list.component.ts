import {Component, OnInit} from '@angular/core';
import {Airport} from '../../model/airport';
import {AirportService} from '../../service/airport.service';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-airport-list',
  templateUrl: './airport-list.component.html',
  styleUrls: ['./airport-list.component.css']
})
export class AirportListComponent implements OnInit {

  airport: Airport[];
  closeResult = '';
  searchValue = '';
  p = 1;
  numberOfItemsPerP = 10;

  constructor(private airportService: AirportService,
              private route: ActivatedRoute,
              private router: Router,
              private modalService: NgbModal) {
  }

  ngOnInit(): void {
    this.getAirports();
  }

  // tslint:disable-next-line:typedef
  getAirports() {
    this.airportService.findAll().subscribe(data => {
      this.airport = [];
      this.airport = data;
    });
  }

  // tslint:disable-next-line:typedef
  addAirport() {
    this.router.navigate(['addAirport']);
  }

  // tslint:disable-next-line:typedef
  editAirport(id: number) {
    this.router.navigate(['editAirport/' + id]);
  }

  // tslint:disable-next-line:typedef
  deleteAirport(id: number) {
    this.airportService.delete(id).subscribe(data => {
      this.getAirports();
    });
  }


  // tslint:disable-next-line:typedef
  open(content, id) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
      this.deleteAirport(id);
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

import { Component, OnInit } from '@angular/core';
import {Hotel} from '../../model/hotel';
import {Observable} from 'rxjs';
import {HotelService} from '../../service/hotel.service';
import {CityService} from '../../../cities/service/city.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-hotel-customer',
  templateUrl: './hotel-customer.component.html',
  styleUrls: ['./hotel-customer.component.css']
})
export class HotelCustomerComponent implements OnInit {
  hotel: Hotel;
  id: number;
  closeResult = '';  // componenta pt modalul de stergere
  photos: Observable<any>;
  constructor(private hotelService: HotelService,
              private cityService: CityService,
              private router: Router,
              private modalService: NgbModal,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    this.hotel = new Hotel();
    this.hotelService.getById(this.id).subscribe(data => {
      this.hotel = new Hotel();
      this.hotel = data;
    });
    this.photos = this.hotelService.getHotelphotos(this.id);
  }
  // tslint:disable-next-line:typedef
  deleteHotel(id: number){
    this.hotelService.delete(id).subscribe(result => {
      this.getHotels();
    });
  }

  // tslint:disable-next-line:typedef
  editHotel(id: number) {
    this.router.navigate(['editHotel' , id]);
  }
  // tslint:disable-next-line:typedef
  open(content, id) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
      this.deleteHotel(id);
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

  // tslint:disable-next-line:typedef
  private getHotels() {
    this.router.navigate(['/hotelsCust']);
  }
}

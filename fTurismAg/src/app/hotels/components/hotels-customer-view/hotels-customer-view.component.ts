import { Component, OnInit } from '@angular/core';
import {Hotel} from '../../model/hotel';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Observable} from 'rxjs';
import {HotelService} from '../../service/hotel.service';
import {ActivatedRoute, Router} from '@angular/router';
import {PhotosService} from '../../service/photos.service';

@Component({
  selector: 'app-hotels-customer-view',
  templateUrl: './hotels-customer-view.component.html',
  styleUrls: ['./hotels-customer-view.component.css']
})
export class HotelsCustomerViewComponent implements OnInit {

  hotels: Hotel[];
  closeResult = '';  // componenta pt modalul de stergere
  searchValue = ''; // componenta pt search
  p = 1;            // pt paginare si urmatoarea la fel
  numberOfItemsPerP = 9;
  photos: Observable<any>;
  constructor(private hotelService: HotelService ,
              private router: Router ,
              private route: ActivatedRoute,
              private modalService: NgbModal,
              private photoService: PhotosService) { }

  ngOnInit(): void {
    this.hotels = [];
    this.getHotels();
  }

  // tslint:disable-next-line:typedef
  public getHotels() {
    this.hotelService.findAll().subscribe(result => {
      this.hotels = [];
      this.hotels = result;
      this.chargePhotos(this.hotels);
    });
  }
  // tslint:disable-next-line:typedef
  addHotel() {
    this.router.navigate(['/addHotel']);
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
  chargePhotos(hotels: Hotel[]){
    for (const hotel of hotels){
      hotel.photos = this.hotelService.getHotelphotos(hotel.id);
    }
  }
  // tslint:disable-next-line:typedef
  viewHotel(id: number){
    this.router.navigate(['viewHotelC' , id]);
  }

}

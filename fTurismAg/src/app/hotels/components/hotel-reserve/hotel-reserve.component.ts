import { Component, OnInit } from '@angular/core';
import {Hotel} from '../../model/hotel';
import {HotelService} from '../../service/hotel.service';
import {CityService} from '../../../cities/service/city.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ModalDismissReasons, NgbCalendar, NgbDate, NgbDateParserFormatter, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Reservationh} from '../../model/reservationh';
import {FormControl, FormGroup} from '@angular/forms';
import {Voucherh} from '../../model/voucherh';
import {VoucherhService} from '../../service/voucherh.service';
import {User} from '../../../users/model/user';
import {AuthService} from '../../../users/service/auth.service';
import {HttpResponse} from '@angular/common/http';

@Component({
  selector: 'app-hotel-reserve',
  templateUrl: './hotel-reserve.component.html',
  styleUrls: ['./hotel-reserve.component.css']
})
export class HotelReserveComponent implements OnInit {
  hotel: Hotel;
  voucherh: Voucherh;
  id: number;
  reservation: Reservationh = new Reservationh();
  hoveredDate: NgbDate;
  fromDate: NgbDate;
  toDate: NgbDate;
  myGroup: FormGroup;
  currentUser: User;
  isLoggedIn = false;
  packets: string[] = ['All Inclusive', 'FullBoard', 'HalfBoard' , 'Bed&Breakfast' , 'Only Bed' ];
  packet: string;
  voucherPacket = 'OB';
  message = '';
  closeResult = '';
  constructor(private hotelService: HotelService,
              private cityService: CityService,
              private router: Router,
              private modalService: NgbModal,
              private route: ActivatedRoute,
              private authService: AuthService,
              private voucherHservice: VoucherhService,
              private calendar: NgbCalendar,
              public formatter: NgbDateParserFormatter) {
    this.fromDate = calendar.getToday();
    this.toDate = calendar.getNext(calendar.getToday(), 'd', 10);
    this.currentUser = new User();
    this.currentUser.username = ''; }

  ngOnInit(): void {
    this.packet = '';
    this.authService.isLoggedIn.subscribe(data => {
      this.isLoggedIn = data;
      this.currentUser = new User();
      if (this.isLoggedIn) {
        this.currentUser = JSON.parse(sessionStorage.getItem(this.authService.USER_DATA_SESSION_ATTRIBUTE_NAME));
        if (this.currentUser === null) {
          this.currentUser = new User();
        }
      }
    });
    this.voucherh = new Voucherh();
    this.id = this.route.snapshot.params.id;
    this.reservation = new Reservationh();
    this.hotel = new Hotel();
    this.hotelService.getById(this.id).subscribe(data => {
      this.hotel = new Hotel();
      this.hotel = data;
    });
    this.myGroup = new FormGroup({
      startDate: new FormControl(),
      endDate: new FormControl(),
    });
  }
  // tslint:disable-next-line:typedef
  public onSubmit(content){
    this.addVoucherPacket();
    this.reservation.checkInDate = this.fromDate.year + '-' + this.fromDate.month + '-' + this.fromDate.day ;
    this.reservation.checkOutDate = this.toDate.year + '-' + this.toDate.month + '-' + this.toDate.day ;
    // tslint:disable-next-line:max-line-length
    this.hotelService.reserve(this.id, this.reservation.checkInDate, this.reservation.checkOutDate, this.reservation.personsNumber, this.voucherh, this.currentUser.username, this.voucherPacket).
    subscribe(result => {
      this.message = result.message;
      console.log(this.message);
      this.open(content);
    });
  }
  // tslint:disable-next-line:typedef
  gotoPage(content){
    this.router.navigate(['reserveHotel/' + this.id]);
  }
  // tslint:disable-next-line:typedef
  private addVoucherPacket(){
    if (this.packet === 'All Inclusive') {
      this.voucherPacket = 'AI';
    }
    if (this.packet === 'FullBoard'){
      this.voucherPacket = 'FB';
    }
    if (this.packet === 'HalfBoard'){
      this.voucherPacket = 'HB';
    }
    if (this.packet === 'Bed&Breakfast'){
      this.voucherPacket = 'BB';
    }
    if (this.packet ===  'Only Bed' ){
      this.voucherPacket = 'OB';
    }
  }
  // tslint:disable-next-line:typedef
  goToHotelList(){
    this.router.navigate(['hotels']);
  }
  // tslint:disable-next-line:typedef
  addVoucher(){
   this.voucherHservice.save(this.voucherh).subscribe();
  }

  // tslint:disable-next-line:typedef
  onDateSelection(date: NgbDate) {
    if (!this.fromDate && !this.toDate) {
      this.fromDate = date;
    } else if (this.fromDate && !this.toDate && date && date.after(this.fromDate)) {
      this.toDate = date;
    } else {
      this.toDate = null;
      this.fromDate = date;
    }
  }

  // tslint:disable-next-line:typedef
  isHovered(date: NgbDate) {
    return this.fromDate && !this.toDate && this.hoveredDate && date.after(this.fromDate) && date.before(this.hoveredDate);
  }

  // tslint:disable-next-line:typedef
  isInside(date: NgbDate) {
    return this.toDate && date.after(this.fromDate) && date.before(this.toDate);
  }

  // tslint:disable-next-line:typedef
  isRange(date: NgbDate) {
    return date.equals(this.fromDate) || (this.toDate && date.equals(this.toDate)) || this.isInside(date) || this.isHovered(date);
  }

  validateInput(currentValue: NgbDate | null, input: string): NgbDate | null {
    const parsed = this.formatter.parse(input);
    return parsed && this.calendar.isValid(NgbDate.from(parsed)) ? NgbDate.from(parsed) : currentValue;
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
  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
}

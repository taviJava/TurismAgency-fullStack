import { Component, OnInit } from '@angular/core';
import {Hotel} from '../../model/hotel';
import {HotelService} from '../../service/hotel.service';
import {CityService} from '../../../cities/service/city.service';
import {ActivatedRoute, Router} from '@angular/router';
import {NgbCalendar, NgbDate, NgbDateParserFormatter, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Reservationh} from '../../model/reservationh';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-hotel-reserve',
  templateUrl: './hotel-reserve.component.html',
  styleUrls: ['./hotel-reserve.component.css']
})
export class HotelReserveComponent implements OnInit {
  hotel: Hotel;
  id: number;
  reservation: Reservationh = new Reservationh();
  hoveredDate: NgbDate;
  fromDate: NgbDate;
  toDate: NgbDate;
  myGroup: FormGroup;
  constructor(private hotelService: HotelService,
              private cityService: CityService,
              private router: Router,
              private modalService: NgbModal,
              private route: ActivatedRoute,
              private calendar: NgbCalendar,
              public formatter: NgbDateParserFormatter) {
    this.fromDate = calendar.getToday();
    this.toDate = calendar.getNext(calendar.getToday(), 'd', 10);  }

  ngOnInit(): void {
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
  public onSubmit(){
    this.reservation.checkInDate = this.fromDate.year + '-' + this.fromDate.month + '-' + (this.fromDate.day + 1);
    this.reservation.checkOutDate = this.toDate.year + '-' + this.toDate.month + '-' + (this.toDate.day + 1);
    this.hotelService.reserve(this.id, this.reservation.checkInDate, this.reservation.checkOutDate, this.reservation.personsNumber).
    subscribe(result => {
      this.goToHotelList();
    });
  }
  // tslint:disable-next-line:typedef
  goToHotelList(){
    this.router.navigate(['hotels']);
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
}

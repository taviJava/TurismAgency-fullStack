import { Component, OnInit } from '@angular/core';
import {CountryService} from '../../../countries/service/country.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {CityService} from '../../service/city.service';
import {City} from '../../model/city';

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CityListComponent implements OnInit {
city: City[];
  closeResult = '';  // componenta pt modalul de stergere
  searchValue = ''; // componenta pt search
  p = 1;            // pt paginare si urmatoarea la fel
  numberOfItemsPerP = 10;
  addCityIccon: string;
  nameIcconVisible = false;
  constructor(private cityService: CityService,
              private route: ActivatedRoute,
              private router: Router,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getCities();
    this.addCityIccon = 'Add City';
  }
  // tslint:disable-next-line:typedef
  getCities() {
    this.cityService.findAll().subscribe(data => {
      this.city = data;
    });
  }
  // tslint:disable-next-line:typedef
  addCity() {
    this.router.navigate(['addCity']);
  }
  // tslint:disable-next-line:typedef
  editCity(id: number) {
    this.router.navigate(['editCity/' + id]);
  }
  // tslint:disable-next-line:typedef
  deleteCity(id: number) {
    this.cityService.delete(id).subscribe(data => {
      this.getCities();
    });
  }

  // tslint:disable-next-line:typedef
  open(content, id) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
      this.deleteCity(id);
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
  mouseEnter() {
    this.nameIcconVisible = true;
  }

  // tslint:disable-next-line:typedef
  mouseLeave() {
    this.nameIcconVisible = false;
  }

}


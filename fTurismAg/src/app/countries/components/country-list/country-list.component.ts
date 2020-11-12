import { Component, OnInit } from '@angular/core';
import {Country} from '../../model/country';
import {CountryService} from '../../service/country.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-country-list',
  templateUrl: './country-list.component.html',
  styleUrls: ['./country-list.component.css']
})
export class CountryListComponent implements OnInit {
country: Country[];
  closeResult = '';  // componenta pt modalul de stergere
  searchValue = ''; // componenta pt search
  p = 1;            // pt paginare si urmatoarea la fel
  numberOfItemsPerP = 10;
  constructor(private countryService: CountryService,
              private route: ActivatedRoute,
              private router: Router,
              private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.getCountries();
  }
  // tslint:disable-next-line:typedef
  getCountries() {
    this.countryService.findAll().subscribe(data => {
      this.country = data;
    });
  }
  // tslint:disable-next-line:typedef
  addCountry() {
    this.router.navigate(['addCountry']);
  }
  // tslint:disable-next-line:typedef
  editCountry(id: number) {
    this.router.navigate(['editCountry/' + id]);
  }
  // tslint:disable-next-line:typedef
  deleteCountry(id: number) {
    this.countryService.delete(id).subscribe(data => {
      this.getCountries();
    });
  }
  // tslint:disable-next-line:typedef
  open(content, id) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
      this.deleteCountry(id);
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

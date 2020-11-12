import {Component, OnInit} from '@angular/core';
import {Continent} from '../../model/continent';
import {ContinentService} from '../../service/continent.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-continent-list',
  templateUrl: './continent-list.component.html',
  styleUrls: ['./continent-list.component.css']
})
export class ContinentListComponent implements OnInit {
  continent: Continent[];
  closeResult = '';
  searchValue = '';
  constructor(private continentService: ContinentService,
              private route: ActivatedRoute,
              private router: Router,
              private modalService: NgbModal
  ) {
  }

  ngOnInit(): void {
    this.getContinent();
  }

  // tslint:disable-next-line:typedef
  getContinent() {
    this.continentService.findAll().subscribe(data => {
      this.continent = data;
    });
  }
  // tslint:disable-next-line:typedef
  addContinent(){
    this.router.navigate(['addContinent']);
  }
  // tslint:disable-next-line:typedef
  editContinent(id: number) {
    this.router.navigate(['editContinent/' + id]);
  }
  // tslint:disable-next-line:typedef
  deleteContinent(id: number) {
    this.continentService.delete(id).subscribe(data => {
      this.getContinent();
    });
  }
  // tslint:disable-next-line:typedef
  open(content, id) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
      this.deleteContinent(id);
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

import { Component, OnInit } from '@angular/core';
import {Participant} from '../../model/participant';
import {ActivatedRoute, Router} from '@angular/router';
import {ParticipantService} from '../../service/participant.service';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-participant-list',
  templateUrl: './participant-list.component.html',
  styleUrls: ['./participant-list.component.css']
})
export class ParticipantListComponent implements OnInit {
participants: Participant[];
closeResult = '';
  searchValue = ''; // componenta pt search
  p = 1;            // pt paginare si urmatoarea la fel
  numberOfItemsPerP = 1;
  constructor(private route: ActivatedRoute,
              private router: Router,
              private participantService: ParticipantService,
              private modalService: NgbModal) { }


  // tslint:disable-next-line:typedef
  getParticipant() {
    this.participantService.findAll().subscribe(data => {
      this.participants = data;
    });
  }
  ngOnInit(): void {
    this.getParticipant();
  }
  // tslint:disable-next-line:typedef
  addParticipant() {
    this.router.navigate(['addparticipant']);
  }
  // tslint:disable-next-line:typedef
  editParticipant(id: number) {
    this.router.navigate(['editparticipant/' + id]);
  }
  // tslint:disable-next-line:typedef
  deleteParticipant(id: number){
    this.participantService.delete(id).subscribe(data =>
    this.getParticipant());
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

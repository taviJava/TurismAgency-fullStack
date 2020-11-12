

import { Component, OnInit } from '@angular/core';
import {Participant} from '../../model/participant';
import {ActivatedRoute, Router} from '@angular/router';
import {ParticipantService} from '../../service/participant.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-participant-edit',
  templateUrl: './participant-edit.component.html',
  styleUrls: ['./participant-edit.component.css']
})
export class ParticipantEditComponent implements OnInit {
participant: Participant;
id: number;
  constructor(private route: ActivatedRoute,
              private router: Router,
              private participantService: ParticipantService,
              private fb: FormBuilder) {
    this.participant = new Participant();
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    this.participantService.getById(this.id).subscribe( data => {
      this.participant = data;
    });
  }
  // tslint:disable-next-line:typedef
  onSubmit() {
    this.participantService.update(this.participant).subscribe(result => this.gotoParticipantsList());
  }

  // tslint:disable-next-line:typedef
  gotoParticipantsList() {
    this.router.navigate(['/participants']);
  }
}

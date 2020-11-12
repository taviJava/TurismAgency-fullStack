import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ParticipantService} from '../../service/participant.service';
import {Participant} from '../../model/participant';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-participant-form',
  templateUrl: './participant-form.component.html',
  styleUrls: ['./participant-form.component.css']
})
export class ParticipantFormComponent implements OnInit {
participant: Participant;
form: FormGroup = new FormGroup({});
  constructor(private route: ActivatedRoute,
              private router: Router,
              private participantService: ParticipantService,
              private fb: FormBuilder) {
    this.form = fb.group(({
      mobileNumber: ['', [Validators.required, Validators.pattern('^((\\+04-?)|0)?[0-9]{10}$')]]
    }));
    this.participant = new Participant();
  }
  ngOnInit(): void {
  }
  // tslint:disable-next-line:typedef
  onSubmit() {
    this.participantService.save(this.participant).subscribe(result =>
    this.gotoParticipantsList());
    console.log(this.form.value);
  }

  // tslint:disable-next-line:typedef
  gotoParticipantsList() {
    this.router.navigate(['/participants']);
  }

  // tslint:disable-next-line:typedef
  get f(){
    return this.form.controls;
  }
}

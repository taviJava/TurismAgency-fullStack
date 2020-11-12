import {Component, OnInit} from '@angular/core';
import {Continent} from '../../model/continent';
import {ContinentService} from '../../service/continent.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-continent-add',
  templateUrl: './continent-add.component.html',
  styleUrls: ['./continent-add.component.css']
})
export class ContinentAddComponent implements OnInit {
  continent: Continent = new Continent();

  constructor(private route: ActivatedRoute,
              private router: Router,
              private continentService: ContinentService
  ) {
  }

  ngOnInit(): void {
  }

// tslint:disable-next-line:typedef
  getContinentsList() {
    this.router.navigate(['continent']);
  }
  // tslint:disable-next-line:typedef
  onSubmit(){
    this.continentService.save(this.continent).subscribe(result => this.getContinentsList());
  }
}

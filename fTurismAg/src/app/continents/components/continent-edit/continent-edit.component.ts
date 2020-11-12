import {Component, OnInit} from '@angular/core';
import {Continent} from '../../model/continent';
import {ContinentService} from '../../service/continent.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-continent-edit',
  templateUrl: './continent-edit.component.html',
  styleUrls: ['./continent-edit.component.css']
})
export class ContinentEditComponent implements OnInit {
  continent: Continent;
  id: number;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private continentService: ContinentService
  ) {
  }

  ngOnInit(): void {
    this.continent = new Continent();
    this.id = this.route.snapshot.params.id;
    this.continentService.getById(this.id).subscribe(data => {
      this.continent = data;
    });

  }

  // tslint:disable-next-line:typedef
  gotoContinentsList() {
    this.router.navigate(['continent']);
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    this.continentService.update(this.continent).subscribe(result => this.gotoContinentsList());
  }

}

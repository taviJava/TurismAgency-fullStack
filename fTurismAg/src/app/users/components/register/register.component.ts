import { Component } from '@angular/core';
import {User} from '../../model/user';
import {ActivatedRoute, Router} from '@angular/router';
import {UserServiceService} from '../../service/user-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent{

  user: User;

  constructor(private userService: UserServiceService,
              private route: ActivatedRoute,
              private router: Router) {
    this.user = new User();
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    this.userService.save(this.user).subscribe(result => this.goToLogin());
  }

  // tslint:disable-next-line:typedef
  goToLogin() {
    this.router.navigate(['']);
  }
}

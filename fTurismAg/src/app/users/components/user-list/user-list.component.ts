import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {User} from '../../model/user';
import {UserServiceService} from '../../service/user-service.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users: User[];

  constructor(private userService: UserServiceService,
              private route: ActivatedRoute,
              private router: Router,
  ) {
  }

  ngOnInit(): void {
    this.getUsers();
  }

  // tslint:disable-next-line:typedef
  getUsers() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }

  // tslint:disable-next-line:typedef
  addUser() {
    this.router.navigate(['register']);
  }

  // tslint:disable-next-line:typedef
  editUser(id: number) {
    this.router.navigate(['editUser', id]);
  }

  // tslint:disable-next-line:typedef
  deleteUser(id: number) {
    this.userService.delete(id).subscribe(data => {
      this.getUsers();
    });
  }
}


import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http: HttpClient) {
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>('http://localhost:8080/getUsers');
  }

  // tslint:disable-next-line:typedef
  public save(user: User) {
    return this.http.post<User>('http://localhost:8080/register', user);
  }

  // tslint:disable-next-line:typedef
  public delete(id: number) {
    return this.http.delete(`${'http://localhost:8080/deleteUser'}/${id}`);
  }

  // tslint:disable-next-line:typedef
  public update(user: User) {
    return this.http.put<User>('http://localhost:8080/updateUser', user);
  }

  // tslint:disable-next-line:typedef
  public getById(id: number): Observable<any> {
    return this.http.get(`${'http://localhost:8080/getUserById'}/${id}`);
  }

  public getByUsername(username: string): Observable<any>{
    return this.http.get(`${'http://localhost:8080/getUserByUsername'}/${username}`);
  }
}

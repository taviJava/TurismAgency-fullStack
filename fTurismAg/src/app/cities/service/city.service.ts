import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Country} from '../../countries/model/country';
import {City} from '../model/city';

@Injectable({
  providedIn: 'root'
})
export class CityService {
  private cityUrl: string;

  constructor(private http: HttpClient) {
    this.cityUrl = 'http://localhost:8080/cities';
  }
  public findAll(): Observable<City[]> {
    return this.http.get<City[]>(this.cityUrl);
  }
  // tslint:disable-next-line:typedef
  public save(city: City) {
    return this.http.post<City>(this.cityUrl, city);
  }
  // tslint:disable-next-line:typedef
  public update(city: City) {
    return this.http.put<City>(this.cityUrl, city);
  }
  public getById(id: number): Observable<any> {
    return this.http.get(`${this.cityUrl}/${id}`);
  }
  // tslint:disable-next-line:typedef
  public delete(id: number) {
    return this.http.delete(`${this.cityUrl}/${id}`);
  }
}

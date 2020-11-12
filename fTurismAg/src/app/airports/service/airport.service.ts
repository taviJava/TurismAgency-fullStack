import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Airport} from '../model/airport';

@Injectable({
  providedIn: 'root'
})
export class AirportService {

  private airportsUrl: string;

  constructor(private http: HttpClient) {
    this.airportsUrl = 'http://localhost:8080/airports';
  }

  public findAll(): Observable<Airport[]> {
    return this.http.get<Airport[]>(this.airportsUrl);
  }

  // tslint:disable-next-line:typedef
  public save(airport: Airport) {
    return this.http.post<Airport>(this.airportsUrl, airport);
  }

  // tslint:disable-next-line:typedef
  public delete(id: number) {
    return this.http.delete(`${this.airportsUrl}/${id}`);
  }

  // tslint:disable-next-line:typedef
  public update(airport: Airport) {
    return this.http.put<Airport>(this.airportsUrl, airport);
  }

  // tslint:disable-next-line:typedef
  public getById(id: number): Observable<any> {
    return this.http.get(`${this.airportsUrl}/${id}`);
  }


}

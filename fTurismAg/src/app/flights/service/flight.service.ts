import { Injectable } from '@angular/core';
import {Flight} from '../model/flight';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Seat} from '../model/seat';
import {Reservationf} from '../model/reservationf';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  private flightsUrl: string;
  constructor(private  http: HttpClient) {
    this.flightsUrl = 'http://localhost:8080/flights';
  }

  public findAll(): Observable<Flight[]>{
    return this.http.get<Flight[]>(this.flightsUrl);
  }
  public getById(id: number): Observable<any>{
    return this.http.get(`${this.flightsUrl}/${id}`);
  }
  // tslint:disable-next-line:typedef
  public save(flight: Flight){
    return this.http.post<Flight>(this.flightsUrl , flight);
  }
  // tslint:disable-next-line:typedef
  public delete(id: number){
    return this.http.delete(`${this.flightsUrl}/${id}`);
  }
  // tslint:disable-next-line:typedef
  public update(flight: Flight){
    return this.http.put<Flight>(this.flightsUrl , flight);
  }
  public getSeatsLeft(id: number): Observable<Seat[]>{
    return this.http.get<Seat[]>(`http://localhost:8080/flights/seatsL/${id}`);
  }
  public getSeatsRight(id: number): Observable<Seat[]>{
    return this.http.get<Seat[]>(`http://localhost:8080/flights/seatsR/${id}`);
  }
  // tslint:disable-next-line:typedef
  public saveR(res: Reservationf, id: number){
    return this.http.post<Reservationf>(`http://localhost:8080/voucher/${id}`, res);
  }
  // tslint:disable-next-line:typedef
  public updateVacancies(id: number, vacancies: number){
    return this.http.put<Flight>(`${this.flightsUrl}/vacancies/${id}/${vacancies}` , null);
  }
}

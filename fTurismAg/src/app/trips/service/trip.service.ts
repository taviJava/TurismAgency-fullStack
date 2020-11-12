import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Participant} from '../../participants/model/participant';
import {Trip} from '../model/trip';

@Injectable({
  providedIn: 'root'
})
export class TripService {
private tripUrl: string;
  constructor(private http: HttpClient) {this.tripUrl = 'http://localhost:8080/trips';
  }
  public findAll(): Observable<Trip[]>{
    return this.http.get<Trip[]>(this.tripUrl);
  }

  // tslint:disable-next-line:typedef
  public save(trip: Trip){
    return this.http.post<Trip>(this.tripUrl, trip);
  }
  // tslint:disable-next-line:typedef
  public update(trip: Trip){
    return this.http.put<Trip>(this.tripUrl, trip);
  }
  public getById(id: number): Observable<any>{
    return this.http.get(`${this.tripUrl}/${id}`);
  }
  // tslint:disable-next-line:typedef
  public delete(id: number){
    return this.http.delete(`${this.tripUrl}/${id}`);
  }
  // participants
  public getUnassignedParticipants(id: number): Observable<Participant[]>{
    return this.http.get<Participant[]>(`${this.tripUrl}/unassignparticipant/${id}`);
  }
  // tslint:disable-next-line:typedef
  public assignParticipantToTrip(trip: Trip, participantList: Participant[]) {
    return this.http.post<Participant[]>(`${this.tripUrl}/assignparticipant/${trip.id}`, participantList);
  }

  // tslint:disable-next-line:typedef
  public unassignParticipantFromTrip(trip: Trip, participantList: Participant[]) {
    return this.http.post<Participant[]>(`${this.tripUrl}/unassignparticipant/${trip.id}`, participantList);
  }
}

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Participant} from '../model/participant';

@Injectable({
  providedIn: 'root'
})
export class ParticipantService {
private participantUrl: string;
  constructor(private http: HttpClient) {
    this.participantUrl = 'http://localhost:8080/participants';
  }
  // @ts-ignore
  public findAll(): Observable<Participant[]>{
    return this.http.get<Participant[]>(this.participantUrl);
  }
  // tslint:disable-next-line:typedef
  public save(participant: Participant){
    return this.http.post<Participant>(this.participantUrl, participant);
  }
  // tslint:disable-next-line:typedef
  public update(participant: Participant){
    return this.http.put<Participant>(this.participantUrl, participant);
  }
  public getById(id: number): Observable<any> {
    return this.http.get(`${this.participantUrl}/${id}`);
  }
  // tslint:disable-next-line:typedef
  public delete(id: number) {
    return this.http.delete(`${this.participantUrl}/${id}`);
  }
}

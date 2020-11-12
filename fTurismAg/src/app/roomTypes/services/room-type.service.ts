import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {RoomType} from '../model/room-type';

@Injectable({
  providedIn: 'root'
})
export class RoomTypeService {
  private roomTypeUrl: string;

  constructor(private http: HttpClient) {
    this.roomTypeUrl = 'http://localhost:8080/roomType';
  }
  public findAll(): Observable<RoomType[]>{
    return this.http.get<[RoomType]>(this.roomTypeUrl);
  }
  // tslint:disable-next-line:typedef
  public save(roomType: RoomType) {
    return this.http.post<RoomType>(this.roomTypeUrl, roomType);
  }
  // tslint:disable-next-line:typedef
  public update(roomType: RoomType) {
    return this.http.put<RoomType>(this.roomTypeUrl, roomType);
  }
  public getById(id: number): Observable<any> {
    return this.http.get(`${this.roomTypeUrl}/${id}`);
  }
  // tslint:disable-next-line:typedef
  public delete(id: number) {
    return this.http.delete(`${this.roomTypeUrl}/${id}`);
  }

}

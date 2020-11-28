import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Hotel} from '../model/hotel';
import {Reservationh} from '../model/reservationh';
import {Voucherh} from '../model/voucherh';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  private hotelsUrl: string;
  constructor(private http: HttpClient) {
    this.hotelsUrl = 'http://localhost:8080/hotels';
  }

  public findAll(): Observable<Hotel[]>{
    return this.http.get<Hotel[]>(this.hotelsUrl);
  }
  public getById(id: number): Observable<any>{
    return this.http.get(`${this.hotelsUrl}/${id}`);
  }
  public getVacancies(id: number, res: Reservationh ): Observable<any>{
    return this.http.get(`${this.hotelsUrl}/vacancies/${id}`);
  }
  // tslint:disable-next-line:typedef
  public save(hotel: Hotel){
  return this.http.post<Hotel>(this.hotelsUrl , hotel);
  }

  // tslint:disable-next-line:typedef
  public delete(id: number){
    return this.http.delete(`${this.hotelsUrl}/${id}`);
  }

  // tslint:disable-next-line:typedef
  public update(hotel: Hotel){
    return this.http.put<Hotel>(this.hotelsUrl , hotel);
  }
  getHotelphotos(id: number): Observable<any> {
    return this.http.get(`${this.hotelsUrl}/photos/${id}`);
  }

  // tslint:disable-next-line:typedef max-line-length
  public reserve(id: number, dateIn: string, dateOut: string, numPers: number, voucher: Voucherh, username: string, packet: string): Observable<any>{
    // tslint:disable-next-line:max-line-length
    return this.http.post<any>(`http://localhost:8080/reserve/hotel/voucher/${id}/${dateIn}/${dateOut}/${numPers}/${username}/${packet}`, voucher);
  }

  // tslint:disable-next-line:max-line-length
  public reserve2(id: number, dateIn: string, dateOut: string, numPers: number, voucher: Voucherh, username: string, packet: string): Observable<HttpEvent<any>> {
    const req = new HttpRequest('POST', `http://localhost:8080/reserve/hotel/voucher/${id}/${dateIn}/${dateOut}/${numPers}/${username}/${packet}`, voucher, {
      reportProgress: true,
      responseType: 'json'
    });
    return this.http.request(req);
  }

  // @PostMapping("/reserve/hotel/voucher/{id}/{dateIn}/{dateOut}/{numPers}/{username}")
}

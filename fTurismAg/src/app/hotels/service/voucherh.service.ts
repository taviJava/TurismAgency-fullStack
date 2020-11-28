import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Hotel} from '../model/hotel';
import {Reservationh} from '../model/reservationh';
import {Voucherh} from '../model/voucherh';

@Injectable({
  providedIn: 'root'
})
export class VoucherhService {
  private voucherhUrl: string;
  constructor(private http: HttpClient) {
    this.voucherhUrl = 'http://localhost:8080/voucherh';
  }
  public findAll(): Observable<Voucherh[]>{
    return this.http.get<Voucherh[]>(this.voucherhUrl);
  }
  public getById(id: number): Observable<any>{
    return this.http.get(`${this.voucherhUrl}/${id}`);
  }
  // tslint:disable-next-line:typedef
  public save(voucher: Voucherh){
    return this.http.post<Hotel>(this.voucherhUrl , voucher);
  }

  // tslint:disable-next-line:typedef
  public delete(id: number){
    return this.http.delete(`${this.voucherhUrl}/${id}`);
  }
}

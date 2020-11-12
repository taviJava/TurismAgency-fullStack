import {Time} from '@angular/common';
import {City} from '../../cities/model/city';
import {Observable} from 'rxjs';

export class Hotel {
  id: number;
  name: string;
  stars: number;
  description: string;
  checkInDate: Date;
  checkOutDate: Date;
  checkInTime: Time;
  checkOutTime: Time;
  paket: string;
  cityModel: City;
  photos: Observable<any>;
}

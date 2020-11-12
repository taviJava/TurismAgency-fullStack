import {City} from '../../cities/model/city';
import {Flight} from '../../flights/model/flight';

export class Airport {
  id: number;
  name: string;
  cityModel: City;
  flightDepartures: Flight[];
  flightArrival: Flight[];
}

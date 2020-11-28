import {Airport} from '../../airports/model/airport';
import {Seat} from './seat';

export class Flight {
  id: number;
  name: string;
  vacancies: number;
  departureDay: string;
  returnDay: string;
  departureHour: string;
  arriveHour: string;
  seatPrice: number;
  rowsNumber: number;
  seatsRowNumber: number;
  airportDeparture: Airport;
  airportArrival: Airport;
  seats: Seat[];
}

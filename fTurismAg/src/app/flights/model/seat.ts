import {Flight} from './flight';
import {Reservationf} from './reservationf';

export class Seat {
  id: number;
  seatName: string;
  flight: Flight;
  reservation: Reservationf;
}

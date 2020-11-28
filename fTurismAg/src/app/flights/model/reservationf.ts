import {Seat} from './seat';

export class Reservationf {
  id: number;
  date: string;
  firstName: string;
  lastName: string;
  documentId: string;
  luggage: string[];
  seat: Seat;
}

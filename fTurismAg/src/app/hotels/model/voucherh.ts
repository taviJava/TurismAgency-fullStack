import {Reservationh} from './reservationh';

export class Voucherh {
   id: number;
   username: string;
  totalPrice: number;
  firstName: string;
  lastName: string;
  documentId: string;
  reservationHotels: Reservationh[];
  numberOfTicketsHotel: number;
}

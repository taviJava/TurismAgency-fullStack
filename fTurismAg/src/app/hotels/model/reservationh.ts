import {Room} from '../../rooms/model/room';

export class Reservationh {
  id: number;
  checkInDate: string;
  checkOutDate: string;
  checkInTime: string;
  checkOutTime: string;
  personsNumber: number;
  room: Room;
}

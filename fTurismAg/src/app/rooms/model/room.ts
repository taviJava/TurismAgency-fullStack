import {RoomType} from '../../roomTypes/model/room-type';

export class Room {
  id: number;
  number: number;
  description: string;
  roomTypeModel: RoomType;
}

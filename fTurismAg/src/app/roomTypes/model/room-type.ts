import {Room} from '../../rooms/model/room';

export class RoomType {
  id: number;
  name: string;
  description: string;
  places: number;
  hasbalcony: boolean;
  roomModelList: Room[];
}

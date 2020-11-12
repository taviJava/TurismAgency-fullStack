import {Trip} from '../../trips/model/trip';

export class Participant {
  id: number;
  firstName: string;
  lastName: string;
   age: number;
   email: string;
   phoneNumber: string;
   address: string;
   tripModels: Trip[];

}

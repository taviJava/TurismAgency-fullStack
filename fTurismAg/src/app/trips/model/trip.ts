import {Participant} from '../../participants/model/participant';
import {Airport} from '../../airports/model/airport';
import {Hotel} from '../../hotels/model/hotel';

export class Trip {
  id: number;
  departureDate: Date;
  returnDate: Date;
  numberOfDays: number;
  priceForAdults: number;
  priceForChildren: number;
  promoted: boolean;
  participantModels: Participant[];
  }

import {Country} from '../../countries/model/country';
import {Hotel} from '../../hotels/model/hotel';
import {Airport} from '../../airports/model/airport';

export class City {
  id: number;
  name: string;
  countryModel: Country;
  hotelModelList: Hotel[];
  airportModel: Airport;
}

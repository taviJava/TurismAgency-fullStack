import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Country} from '../model/country';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CountryService {
  private countryUrl: string;

  constructor(private http: HttpClient) {
    this.countryUrl = 'http://localhost:8080/country';
  }
  public findAll(): Observable<Country[]> {
    return this.http.get<Country[]>(this.countryUrl);
  }
  // tslint:disable-next-line:typedef
  public save(country: Country) {
    return this.http.post<Country>(this.countryUrl, country);
  }
  // tslint:disable-next-line:typedef
  public update(country: Country) {
    return this.http.put<Country>(this.countryUrl, country);
  }
  public getById(id: number): Observable<any> {
    return this.http.get(`${this.countryUrl}/${id}`);
  }
  // tslint:disable-next-line:typedef
  public delete(id: number) {
    return this.http.delete(`${this.countryUrl}/${id}`);
  }

}

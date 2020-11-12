import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Continent} from '../model/continent';

@Injectable({
  providedIn: 'root'
})
export class ContinentService {
  private continentUrl: string;

  constructor(private http: HttpClient) {
    this.continentUrl = 'http://localhost:8080/continent';

  }
  public findAll(): Observable<Continent[]>{
return this.http.get<Continent[]>(this.continentUrl);
  }
  // tslint:disable-next-line:typedef
  public save(continent: Continent) {
    return this.http.post<Continent>(this.continentUrl, continent);
  }
  // tslint:disable-next-line:typedef
  public update(continent: Continent) {
    return this.http.put<Continent>(this.continentUrl, continent);
  }
  public getById(id: number): Observable<any> {
    return this.http.get(`${this.continentUrl}/${id}`);
  }
  // tslint:disable-next-line:typedef
    public delete(id: number) {
    return this.http.delete(`${this.continentUrl}/${id}`);
  }

}

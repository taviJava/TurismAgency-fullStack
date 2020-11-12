import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class PhotosService {
  private photosUrl: string;
  constructor(private http: HttpClient) {
    this.photosUrl = 'http://localhost:8080/photos';
  }
  upload(photo: File, id: number): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('photo', photo);

    const req = new HttpRequest('POST', this.photosUrl, formData,  {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }

  getFiles(): Observable<any> {
    return this.http.get(this.photosUrl);}
}

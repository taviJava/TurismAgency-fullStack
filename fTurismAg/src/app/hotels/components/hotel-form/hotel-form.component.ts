import { Component, OnInit } from '@angular/core';
import {Hotel} from '../../model/hotel';
import {HotelService} from '../../service/hotel.service';
import {ActivatedRoute, Router} from '@angular/router';
import {IDropdownSettings} from 'ng-multiselect-dropdown';
import {City} from '../../../cities/model/city';
import {CityService} from '../../../cities/service/city.service';
import {PhotosService} from '../../service/photos.service';
import {HttpEventType, HttpResponse} from '@angular/common/http';
import {debounceTime} from 'rxjs/operators';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-hotel-form',
  templateUrl: './hotel-form.component.html',
  styleUrls: ['./hotel-form.component.css']
})
export class HotelFormComponent implements OnInit {

  hotel: Hotel;
  hotels: Hotel[];
  dropdownSettings: IDropdownSettings = {};
  cities: City[];
  selectedCity: City[];
  selectedPhotos: FileList;
  progressInfos = [];
  currentPhoto: File;
  progress = 0;
  message = '';
  photos: Observable<any>;
  constructor(private hotelService: HotelService,
              private cityService: CityService,
              private router: Router,
              private route: ActivatedRoute,
              private photoService: PhotosService) {

  }

  ngOnInit(): void {
    this.hotel = new Hotel();
    this.cities = [];
    this.hotels = [];
    this.selectedCity = [];
    this.cityService.findAll().subscribe(data => {
      this.cities = [];
      this.cities = data; } );
    this.dropdownSettings = {
      singleSelection: true,
      idField: 'id',
      textField: 'name',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true,
    };
  }

  // tslint:disable-next-line:typedef
  onSubmit(){
    this.hotel.cityModel = this.selectedCity[0];
    this.hotelService.save(this.hotel).subscribe(event => {
      this.getHotel();
    } );

  }
  // tslint:disable-next-line:typedef
  getHotel(){
    this.hotelService.findAll().subscribe(result => {
      this.hotels = [];
      this.hotels = result;
      this.hotel = this.hotels[(this.hotels.length - 1)];
      console.log(this.hotel);
      this.uploadPhotos(this.hotel.id);
    });
    this.goToHotelList();
  }

  // tslint:disable-next-line:typedef
  goToHotelList(){
  this.router.navigate(['/hotels']);
  }

  // tslint:disable-next-line:typedef
  onItemSelect(item: any) {
    console.log(item);
  }

  // tslint:disable-next-line:typedef
  onSelectAll(items: any) {
    console.log(items);
  }

  selectPhoto(event): void {
    this.progressInfos = [];

    const files = event.target.files;
    let isImage = true;

    for (let i = 0; i < files.length; i++) {
      if (files.item(i).type.match('image.*')) {
        continue;
      } else {
        isImage = false;
        alert('invalid format!');
        break;
      }
    }

    if (isImage) {
      this.selectedPhotos = event.target.files;
    } else {
      this.selectedPhotos = undefined;
      event.srcElement.percentage = null;
    }
  }
  uploadPhotos(id: number): void {
    this.message = '';

    for (let i = 0; i < this.selectedPhotos.length; i++) {
      this.upload(i, this.selectedPhotos[i], id);
    }
  }
  upload(idx, file, id: number): void {
    this.progressInfos[idx] = { value: 0, fileName: file.name };

    this.photoService.upload(file, id).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progressInfos[idx].percentage = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          this.photos = this.photoService.getFiles();
        }
      },
      err => {
        this.progressInfos[idx].percentage = 0;
        this.message = 'Could not upload the file:' + file.name;
      });
  }
}

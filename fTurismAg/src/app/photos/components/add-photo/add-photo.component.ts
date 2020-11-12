import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PhotoService} from '../../service/photo.service';
import {HttpClient} from '@angular/common/http';
import {Photo} from '../../model/photo';

@Component({
  selector: 'app-add-photo',
  templateUrl: './add-photo.component.html',
  styleUrls: ['./add-photo.component.css']
})
export class AddPhotoComponent implements OnInit {
  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResponse: any;
  message: string;
  imageName: any;
  reader = new FileReader();
  photo: Photo;
  blob: Blob;
   uploadImageData = new FormData();
  constructor(private route: ActivatedRoute,
              private router: Router,
              private photoService: PhotoService,
              private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.blob = new Blob();
this.photo = new Photo();

  }
  // tslint:disable-next-line:typedef
  buildRequest() {
    return {
      create: {
        fileData: this.reader.readAsArrayBuffer(this.selectedFile)
      }
    };
  }
  // tslint:disable-next-line:typedef
  public onFileChanged(event) {
    // Select File
    this.selectedFile = event.target.files[0];
  }
  // tslint:disable-next-line:typedef
  onUpload() {
    console.log(this.selectedFile);
    // FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);
    // Make a call to the Spring Boot Application to save the image
    this.httpClient.post('http://localhost:8080/photos', uploadImageData, { observe: 'response' })
      .subscribe((response) => {
        if (response.status === 200) {
          this.message = 'Image uploaded successfully';
        } else {
          this.message = 'Image not uploaded successfully';
        }
      } );
  }


  // tslint:disable-next-line:typedef
  getImage(id: number) {
    this.httpClient.get('http://localhost:8080/photos/' + id)
      .subscribe(
        res => {
          this.retrieveResponse = res;
          this.base64Data = this.retrieveResponse.picByte;
          this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
        }
      );
  }
}

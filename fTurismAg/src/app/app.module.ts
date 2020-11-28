import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ContinentListComponent} from './continents/components/continent-list/continent-list.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ContinentAddComponent } from './continents/components/continent-add/continent-add.component';
import {ContinentEditComponent} from './continents/components/continent-edit/continent-edit.component';
import { CountryListComponent } from './countries/components/country-list/country-list.component';
import { MenuComponent } from './common/component/menu/menu.component';
import { CountryAddComponent } from './countries/components/country-add/country-add.component';
import { CountryEditComponent } from './countries/components/country-edit/country-edit.component';
import {CarouselModule, MDBBootstrapModule, WavesModule} from 'angular-bootstrap-md';
import {NgMultiSelectDropDownModule} from 'ng-multiselect-dropdown';
import {NgSelectModule} from '@ng-select/ng-select';
import {HotelListComponent} from './hotels/components/hotel-list/hotel-list.component';
import {FlightListComponent} from './flights/components/flight-list/flight-list.component';
import {HotelFormComponent} from './hotels/components/hotel-form/hotel-form.component';
import {FlightFormComponent} from './flights/components/flight-form/flight-form.component';
import {HotelEditComponent} from './hotels/components/hotel-edit/hotel-edit.component';
import {FlightEditComponent} from './flights/components/flight-edit/flight-edit.component';
import {ParticipantListComponent} from './participants/components/participant-list/participant-list.component';
import {ParticipantFormComponent} from './participants/components/participant-form/participant-form.component';
import {ParticipantEditComponent} from './participants/components/participant-edit/participant-edit.component';
import {AirportListComponent} from './airports/components/airport-list/airport-list.component';
import {AirportAddComponent} from './airports/components/airport-add/airport-add.component';
import {AirportEditComponent} from './airports/components/airport-edit/airport-edit.component';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {NgxPaginationModule} from 'ngx-pagination';
import {CityListComponent} from './cities/components/city-list/city-list.component';
import {CityAddComponent} from './cities/components/city-add/city-add.component';
import {CityEditComponent} from './cities/components/city-edit/city-edit.component';
import { AddPhotoComponent } from './photos/components/add-photo/add-photo.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatGridListModule} from '@angular/material/grid-list';
import {RoomtypeListComponent} from './roomTypes/components/roomtype-list/roomtype-list.component';
import {RoomtypeAddComponent} from './roomTypes/components/roomtype-add/roomtype-add.component';
import {RoomAddComponent} from './rooms/components/room-add/room-add.component';
import {RoomtypeEditComponent} from './roomTypes/components/roomtype-edit/roomtype-edit.component';
import {RoomListComponent} from './rooms/components/room-list/room-list.component';
import {RoomEditComponent} from './rooms/components/room-edit/room-edit.component';
import { HotelViewComponent } from './hotels/components/hotel-view/hotel-view.component';

import {HotelService} from './hotels/service/hotel.service';
import {RoomService} from './rooms/services/room.service';
import {AirportService} from './airports/service/airport.service';
import {CityService} from './cities/service/city.service';
import {CountryService} from './countries/service/country.service';
import {FlightService} from './flights/service/flight.service';
import {ParticipantService} from './participants/service/participant.service';
import {PhotoService} from './photos/service/photo.service';
import {PhotosService} from './hotels/service/photos.service';
import {RoomTypeService} from './roomTypes/services/room-type.service';
import {NgImageSliderModule} from 'ng-image-slider';
import { UserListComponent } from './users/components/user-list/user-list.component';
import { RegisterComponent } from './users/components/register/register.component';
import {UserServiceService} from './users/service/user-service.service';
import { UserEditComponent } from './users/components/user-edit/user-edit.component';
import { LoginComponent } from './users/components/login/login.component';
import {HttpInterceptorService} from './users/service/http-interceptor.service';
import { HotelReserveComponent } from './hotels/components/hotel-reserve/hotel-reserve.component';
import { FlightReserveComponent } from './flights/components/flight-reserve/flight-reserve.component';
import { HotelsCustomerViewComponent } from './hotels/components/hotels-customer-view/hotels-customer-view.component';
import { FlightsCustomerComponent } from './flights/components/flights-customer/flights-customer.component';
import { HomepageComponent } from './common/component/homepage/homepage.component';
import { HotelCustomerComponent } from './hotels/components/hotel-customer/hotel-customer.component';
import { PaymentComponent } from './common/component/payment/payment.component';
import { PaymentMessageComponent } from './common/component/payment/payment-message/payment-message.component';
import { ContactPageComponent } from './common/component/contact-page/contact-page.component';
import { ContactMessageComponent } from './common/component/contact-page/contact-message/contact-message.component';




@NgModule({
  declarations: [
    AppComponent,
    ContinentListComponent,
    ContinentAddComponent,
    ContinentEditComponent,
    CountryListComponent,
    MenuComponent,
    CountryAddComponent,
    CountryEditComponent,
    HotelListComponent,
    FlightListComponent,
    HotelFormComponent,
    FlightFormComponent,
    HotelEditComponent,
    FlightEditComponent,
    ParticipantListComponent,
    ParticipantFormComponent,
    ParticipantEditComponent,
    AirportListComponent,
    AirportAddComponent,
    AirportEditComponent,
    CityListComponent,
    CityAddComponent,
    CityEditComponent,
    AddPhotoComponent,
    RoomtypeListComponent,
    RoomtypeAddComponent,
    RoomtypeEditComponent,
    RoomListComponent,
    RoomAddComponent,
    RoomEditComponent,
    HotelViewComponent,
    UserListComponent,
    RegisterComponent,
    UserEditComponent,
    LoginComponent,
    HotelReserveComponent,
    FlightReserveComponent,
    HotelsCustomerViewComponent,
    FlightsCustomerComponent,
    HomepageComponent,
    HotelCustomerComponent,
    PaymentComponent,
    PaymentMessageComponent,
    ContactPageComponent,
    ContactMessageComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        NgbModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule,
        MDBBootstrapModule.forRoot(),
        NgMultiSelectDropDownModule.forRoot(),
        NgSelectModule,
        NgImageSliderModule,
        BrowserModule, Ng2SearchPipeModule,
        BrowserModule, NgxPaginationModule, BrowserAnimationsModule, MatGridListModule,
      CarouselModule, WavesModule

    ],
  providers: [HotelService , RoomService , AirportService , CityService, CountryService , FlightService
   , ParticipantService ,  PhotoService , PhotosService , RoomTypeService  , UserServiceService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule {
}

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ContinentListComponent} from './continents/components/continent-list/continent-list.component';
import {ContinentAddComponent} from './continents/components/continent-add/continent-add.component';
import {ContinentEditComponent} from './continents/components/continent-edit/continent-edit.component';
import {CountryListComponent} from './countries/components/country-list/country-list.component';
import {CountryAddComponent} from './countries/components/country-add/country-add.component';
import {CountryEditComponent} from './countries/components/country-edit/country-edit.component';
import {HotelFormComponent} from './hotels/components/hotel-form/hotel-form.component';
import {HotelListComponent} from './hotels/components/hotel-list/hotel-list.component';
import {FlightListComponent} from './flights/components/flight-list/flight-list.component';
import {FlightFormComponent} from './flights/components/flight-form/flight-form.component';
import {HotelEditComponent} from './hotels/components/hotel-edit/hotel-edit.component';
import {ParticipantListComponent} from './participants/components/participant-list/participant-list.component';
import {ParticipantFormComponent} from './participants/components/participant-form/participant-form.component';
import {ParticipantEditComponent} from './participants/components/participant-edit/participant-edit.component';
import {FlightEditComponent} from './flights/components/flight-edit/flight-edit.component';
import {AirportListComponent} from './airports/components/airport-list/airport-list.component';
import {AirportAddComponent} from './airports/components/airport-add/airport-add.component';
import {AirportEditComponent} from './airports/components/airport-edit/airport-edit.component';
import {CityListComponent} from './cities/components/city-list/city-list.component';
import {CityEditComponent} from './cities/components/city-edit/city-edit.component';
import {CityAddComponent} from './cities/components/city-add/city-add.component';
import {AddPhotoComponent} from './photos/components/add-photo/add-photo.component';
import {RoomtypeListComponent} from './roomTypes/components/roomtype-list/roomtype-list.component';
import {RoomAddComponent} from './rooms/components/room-add/room-add.component';
import {RoomListComponent} from './rooms/components/room-list/room-list.component';
import {RoomtypeEditComponent} from './roomTypes/components/roomtype-edit/roomtype-edit.component';
import {RoomEditComponent} from './rooms/components/room-edit/room-edit.component';
import {RoomtypeAddComponent} from './roomTypes/components/roomtype-add/roomtype-add.component';
import {UserListComponent} from './users/components/user-list/user-list.component';
import {RegisterComponent} from './users/components/register/register.component';
import {UserEditComponent} from './users/components/user-edit/user-edit.component';
import {LoginComponent} from './users/components/login/login.component';
import {MenuComponent} from './common/component/menu/menu.component';
import {HotelViewComponent} from './hotels/components/hotel-view/hotel-view.component';
import {HotelReserveComponent} from './hotels/components/hotel-reserve/hotel-reserve.component';
import {FlightReserveComponent} from './flights/components/flight-reserve/flight-reserve.component';
import {HotelsCustomerViewComponent} from './hotels/components/hotels-customer-view/hotels-customer-view.component';
import {FlightsCustomerComponent} from './flights/components/flights-customer/flights-customer.component';
import {HomepageComponent} from './common/component/homepage/homepage.component';
import {HotelCustomerComponent} from './hotels/components/hotel-customer/hotel-customer.component';
import {PaymentComponent} from './common/component/payment/payment.component';
import {PaymentMessageComponent} from './common/component/payment/payment-message/payment-message.component';
import {ContactPageComponent} from './common/component/contact-page/contact-page.component';
import {ContactMessageComponent} from './common/component/contact-page/contact-message/contact-message.component';


const routes: Routes = [
  {path: 'getUsers', component: UserListComponent},
  {path: 'payment', component: PaymentComponent},
  {path: 'paymentMessage', component: PaymentMessageComponent},
  {path: 'contact', component: ContactPageComponent},
  {path: 'contactMessage', component: ContactMessageComponent},
  {path: 'homepage', component: HomepageComponent},
  {path: '', component: LoginComponent},
  {path: 'editUser/:id', component: UserEditComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'continent', component: ContinentListComponent},
  {path: 'addContinent', component: ContinentAddComponent},
  {path: 'editContinent/:id', component: ContinentEditComponent },
  {path: 'countries', component: CountryListComponent},
  {path: 'addCountry', component: CountryAddComponent},
  {path: 'editCountry/:id', component: CountryEditComponent},
  {path: 'hotels' , component: HotelListComponent},
  {path: 'hotelsCust' , component: HotelsCustomerViewComponent},
  {path: 'flights' , component: FlightListComponent},
  {path: 'flights/customers' , component: FlightsCustomerComponent},
  {path: 'addHotel' , component: HotelFormComponent},
  {path: 'addFlight' , component: FlightFormComponent},
  {path: 'editHotel/:id' , component: HotelEditComponent},
  {path: 'editFlight/:id' , component: FlightEditComponent},
  {path: 'viewHotel/:id' , component: HotelViewComponent},
  {path: 'viewHotelC/:id' , component: HotelCustomerComponent},
  {path: 'reserveHotel/:id' , component: HotelReserveComponent},
  {path: 'reserveFlight/:id' , component: FlightReserveComponent},
  {path: 'participants', component: ParticipantListComponent },
  {path: 'addparticipant', component: ParticipantFormComponent},
  {path: 'editparticipant/:id', component: ParticipantEditComponent},
  {path: 'airports', component: AirportListComponent},
  {path: 'addAirport', component: AirportAddComponent},
  {path: 'editAirport/:id', component: AirportEditComponent},
   {path: 'cities', component: CityListComponent},
  {path: 'addCity', component: CityAddComponent},
  {path: 'editCity/:id', component: CityEditComponent},
  {path: 'photos', component: AddPhotoComponent},
{path: 'roomType', component: RoomtypeListComponent},
{path: 'addRoomType', component: RoomtypeAddComponent},
{path: 'editRoomType/:id', component: RoomtypeEditComponent},
{path: 'room/:id', component: RoomListComponent},
{path: 'addRooms/:idH', component: RoomAddComponent},
{path: 'editRoom/:id', component: RoomEditComponent},
{path: 'menu', component: MenuComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

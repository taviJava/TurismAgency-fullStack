package com.example.ProjectTogether.controller;


import com.example.ProjectTogether.model.CityModel;
import com.example.ProjectTogether.model.CountryModel;
import com.example.ProjectTogether.model.HotelModel;
import com.example.ProjectTogether.model.ReservationHotel;
import com.example.ProjectTogether.model.files.ResponseFile;
import com.example.ProjectTogether.repository.HotelRepository;
import com.example.ProjectTogether.repository.ReservationHotelRepository;
import com.example.ProjectTogether.service.PhotoHotelStorageService;
import com.example.ProjectTogether.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class HotelController {
  @Autowired
  private ReservationHotelRepository reservationHotelRepository;
  @Autowired
  private HotelRepository hotelRepository;
  @Autowired
  private PhotoHotelStorageService photoHotelStorageService;

  @Autowired
  private ReservationService reservationService;
  @GetMapping("/hotels")
  public List<HotelModel> getHotels() {
    List<HotelModel> hotelModels = new ArrayList<>();
    for (HotelModel hotelModel: hotelRepository.findAll()){
      HotelModel hotel = new HotelModel();
      hotel.setId(hotelModel.getId());
      hotel.setName(hotelModel.getName());
      hotel.setDescription(hotel.getDescription());
      hotel.setPaket(hotelModel.getPaket());
      CityModel cityModel = new CityModel();
      cityModel.setName(hotelModel.getCityModel().getName());
      hotel.setCityModel(cityModel);
      hotelModels.add(hotel);

    }


    return hotelModels;
  }

  @GetMapping("/hotels/{id}")
  public HotelModel getHotel(@PathVariable(name = "id") Long id) {
    Optional<HotelModel> hotelModelOptional = hotelRepository.findById(id);
    HotelModel hotel = new HotelModel();
    if (hotelModelOptional.isPresent()){
      HotelModel hotelModel = hotelModelOptional.get();
      hotel.setId(hotelModel.getId());
      hotel.setName(hotelModel.getName());
      hotel.setDescription(hotel.getDescription());
      hotel.setPaket(hotelModel.getPaket());
      CityModel cityModel = new CityModel();
      cityModel.setName(hotelModel.getCityModel().getName());
      hotel.setCityModel(cityModel);
    }

    return hotel;
  }


  @PostMapping("/hotels")
  public void addHotel(@RequestBody HotelModel hotel) {
    hotelRepository.save(hotel);
  }

  @DeleteMapping("/hotels/{id}")
  public void deleteHotel(@PathVariable(name = "id") Long hotelId) {
    hotelRepository.deleteById(hotelId);
  }

  @PutMapping("/hotels")
  public void updateHotel(@RequestBody HotelModel hotel) {
    HotelModel updatedHotel = hotelRepository.findById(hotel.getId()).orElse(null);
    updatedHotel.setName(hotel.getName());
    updatedHotel.setStars(hotel.getStars());
    updatedHotel.setDescription(hotel.getDescription());
    updatedHotel.setPaket(hotel.getPaket());
    hotelRepository.save(hotel);
  }
  @GetMapping("/hotels/photos/{id}")
  public ResponseEntity<List<ResponseFile>> getListFiles(@PathVariable(name = "id") Long id) {
    HotelModel hotelModel = hotelRepository.findById(id).orElse(null);
    List<ResponseFile> files = photoHotelStorageService.getAllHotelphotos(hotelModel).map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
              .fromCurrentContextPath()
              .path("/photos/")
              .path(dbFile.getId())
              .toUriString();
      return new ResponseFile(
              dbFile.getName(),
              fileDownloadUri,
              dbFile.getType(),
              dbFile.getData().length);
    }).collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(files);
  }

  @GetMapping("/hotels/vacancies/{idH}")
  public Integer getHotel(@PathVariable(name = "idH") Long idH,@RequestBody ReservationHotel reservationHotel ) {
    return reservationService.returnHotelVacancies(idH,reservationHotel);
  }

  @GetMapping("/reservation")
  public List<ReservationHotel> deTest(){
    List<ReservationHotel> reservationHotels = new ArrayList<>();
    for (ReservationHotel reservation: reservationHotelRepository.findAll()){
      ReservationHotel reservationHotel = new ReservationHotel();
      reservationHotel.setId(reservation.getId());
      reservationHotel.setCheckInDate(reservation.getCheckInDate());
      reservationHotel.setCheckInTime(reservation.getCheckInTime());
      reservationHotel.setCheckOutDate(reservation.getCheckOutDate());
      reservationHotel.setCheckOutTime(reservation.getCheckOutTime());
      reservationHotels.add(reservationHotel);
    }
    return reservationHotels;
  }

 }

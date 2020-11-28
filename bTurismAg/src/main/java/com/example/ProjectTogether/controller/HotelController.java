package com.example.ProjectTogether.controller;


import com.example.ProjectTogether.persistance.dto.HotelDto;
import com.example.ProjectTogether.persistance.model.CityModel;
import com.example.ProjectTogether.persistance.model.HotelModel;
import com.example.ProjectTogether.persistance.model.ReservationHotel;
import com.example.ProjectTogether.persistance.model.files.ResponseFile;
import com.example.ProjectTogether.repository.HotelRepository;
import com.example.ProjectTogether.repository.ReservationHotelRepository;
import com.example.ProjectTogether.service.HotelService;
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
 private  HotelService hotelService;
  @Autowired
  private ReservationService reservationService;
  @GetMapping("/hotels")
  public List<HotelDto> getHotels() {
   return hotelService.getAll();
  }

  @GetMapping("/hotels/{id}")
  public HotelDto getHotel(@PathVariable(name = "id") Long id) {
  return hotelService.getOne(id);
  }


  @PostMapping("/hotels")
  public void addHotel(@RequestBody HotelDto hotel) {
    hotelService.save(hotel);
  }

  @DeleteMapping("/hotels/{id}")
  public void deleteHotel(@PathVariable(name = "id") Long hotelId) {
    hotelService.delete(hotelId);
  }

  @PutMapping("/hotels")
  public void updateHotel(@RequestBody HotelDto hotel) {
 hotelService.update(hotel);
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

  @GetMapping("/reservationall")
  public List<ReservationHotel> getAllRes(){
    List<ReservationHotel> reservationHotels = new ArrayList<>();
    for (ReservationHotel reservationHotel: reservationHotelRepository.findAll()){
      ReservationHotel reservation = new ReservationHotel();
      reservation.setPersonsNumber(reservationHotel.getPersonsNumber());
      reservation.setCheckInDate(reservationHotel.getCheckOutDate());
      reservation.setCheckInDate(reservationHotel.getCheckInDate());
      reservation.setCheckInTime(reservationHotel.getCheckInTime());
      reservation.setCheckOutTime(reservationHotel.getCheckOutTime());
      reservation.setId(reservationHotel.getId());
      reservationHotels.add(reservation);
    }
    return reservationHotels;
  }

 }

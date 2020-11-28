package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.persistance.model.ReservationHotel;
import com.example.ProjectTogether.persistance.model.RoomModel;
import com.example.ProjectTogether.repository.ReservationHotelRepository;
import com.example.ProjectTogether.repository.RoomRepository;
import com.example.ProjectTogether.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationHotelRepository reservationHotelRepository;

    // public void createRooms(long idRoomType, long idHotel, int numRooms)


    @PostMapping("/room/{idRoomType}/{idHotel}/{numRooms}")
    public void addRoom(@PathVariable(name = "idRoomType") Long idRoomType,@PathVariable(name = "idHotel") Long idHotel,@PathVariable(name = "numRooms") int numRooms){
        reservationService.createRooms(idRoomType, idHotel, numRooms);
    }

    @DeleteMapping("/room/{id}")
    public void deleteRoom(@PathVariable(name = "id") Long id) {
        roomRepository.deleteById(id);
    }

    @GetMapping("/rooms/{id}")
    public List<RoomModel> getRooms(@PathVariable(name = "id") Long id) {
        return reservationService.roomModels(id);
    }

    @GetMapping("/room/{id}")
    public RoomModel getRoomById(@PathVariable(name = "id") Long id) {
        return roomRepository.findById(id).orElse(null);
    }

//    @PostMapping("/reserve/{id}/{dateIn}/{dateOut}/{numPers}")
//    public void reserve(@PathVariable(name = "id") Long id, @PathVariable(name = "dateIn") String dateIn, @PathVariable(name = "dateOut") String dateOut,@PathVariable(name = "numPers") int numPers) {
//        ReservationHotel reservation = new ReservationHotel();
//        reservation.setCheckInDate(java.sql.Date.valueOf(dateIn));
//        reservation.setCheckOutDate(java.sql.Date.valueOf(dateOut));
//        reservation.setPersonsNumber(numPers);
//        reservationService.reserve(reservation,id);
//    }

    @GetMapping("reserve/{id}")
    public ReservationHotel getReservation(@PathVariable(name = "id") Long id){
        Optional<ReservationHotel> reservationHotelOptional = reservationHotelRepository.findById(id);
        ReservationHotel reservationHotel = new ReservationHotel();
        if (reservationHotelOptional.isPresent()){
            ReservationHotel res = reservationHotelOptional.get();
            reservationHotel.setId(res.getId());
            reservationHotel.setCheckInDate(res.getCheckInDate());
            reservationHotel.setCheckOutDate(res.getCheckOutDate());
            reservationHotel.setPersonsNumber(res.getPersonsNumber());
        }

        return reservationHotel;
    }

//    @PutMapping("/reserve/{id}")
//    public void reserveTest(@PathVariable(name = "id") Long id) {
//        ReservationHotel reservationHotel = new ReservationHotel();
//        Date startTime = java.sql.Date.valueOf("2020-12-4");                       // 23:32:45
//        Date endTime = java.sql.Date.valueOf("2020-12-8");
//        reservationHotel.setCheckInDate(startTime);
//        reservationHotel.setCheckOutDate(endTime);
//        reservationHotel.setPersonsNumber(2);
//        reservationService.reserve(reservationHotel,id);
//    }
}

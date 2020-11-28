package com.example.ProjectTogether.service;

import com.example.ProjectTogether.persistance.model.*;
import com.example.ProjectTogether.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class ReservationService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ReservationHotelRepository reservationHotelRepository;
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    @Autowired
    private VoucherHService voucherHService;

    private boolean ifIsReserved(RoomModel room, ReservationHotel rezNew){
        for (ReservationHotel rezOld: room.getReservations()){
            if (verifyRoomReservation(rezOld,rezNew)){
                return true;

            }

        }

        return false;
    }
    private boolean verifyRoomReservation(ReservationHotel rezOld, ReservationHotel rezNew){
        if (rezNew.getCheckInDate().toLocalDate().equals(rezOld.getCheckInDate().toLocalDate())){
            return true;
        }else if (rezNew.getCheckInDate().toLocalDate().isBefore(rezOld.getCheckInDate().toLocalDate()) && rezNew.getCheckOutDate().toLocalDate().isAfter(rezOld.getCheckInDate().toLocalDate())){
            return true;
        }else if (rezNew.getCheckInDate().toLocalDate().isAfter(rezOld.getCheckInDate().toLocalDate()) && rezNew.getCheckInDate().toLocalDate().isBefore(rezOld.getCheckOutDate().toLocalDate())){
            return true;
        }
        return false;
    }

    private boolean verifyPlaces(RoomModel room, ReservationHotel reservation){
        if (room.getRoomTypeModel().getPlaces() >= reservation.getPersonsNumber()){
            return true;
        }
        return false;
    }

    public String reserve(ReservationHotel reservation, long id, VoucherH voucherH, String username, String packet) throws InterruptedException {
        Optional<HotelModel> hotelModelOptional = hotelRepository.findById(id);
        int a = reservationHotelRepository.findAll().size();
        if (hotelModelOptional.isPresent()){
            HotelModel hotelModel = hotelModelOptional.get();
            HotelModel hotel = new HotelModel();
            hotel.setId(hotelModel.getId());
            List<RoomModel> roomModels = new ArrayList<>();
            transform(roomModels,hotelModel);
            hotel.setRooms(roomModels);
            for (RoomModel room: hotel.getRooms()){
                if (verifyPlaces(room,reservation)){
                    if ((room.getReservations().size()==0) || (!ifIsReserved(room, reservation) && (room.getReservations().size()>0))) {
                     saveReservation(reservation,room,voucherH,username,packet);
                        break;
                    }
                }
            }
        }
        if (a==reservationHotelRepository.findAll().size()){
            return "The reservation could not be added";
        }else {
            return "The reservation has been added";
        }
    }

    private void saveReservation(ReservationHotel reservation, RoomModel room, VoucherH voucherH, String username, String packet) throws InterruptedException {
        if ((room.getReservations().size()==0) || (!ifIsReserved(room, reservation) && (room.getReservations().size()>0))) {
            Time startTime = java.sql.Time.valueOf("14:00:00");                       // 23:32:45
            Time endTime = java.sql.Time.valueOf("12:00:00");
            reservation.setCheckInTime(startTime);
            reservation.setCheckOutTime(endTime);
            reservation.setRoom(room);
            reservationHotelRepository.save(reservation);
            TimeUnit.SECONDS.sleep(2);
            voucherHService.addReservationsH(voucherH,username,packet);
        }
    }

    private void transform(List<RoomModel> roomModels, HotelModel hotelModel){
        for (RoomModel roomModel: hotelModel.getRooms() ){
            RoomModel roomModel1 = new RoomModel();
            roomModel1.setId(roomModel.getId());
            RoomTypeModel roomTypeModel = new RoomTypeModel();
            roomTypeModel.setId(roomModel.getRoomTypeModel().getId());
            roomTypeModel.setPlaces(roomModel.getRoomTypeModel().getPlaces());
            roomModel1.setRoomTypeModel(roomTypeModel);
            List<ReservationHotel> reservationHotels = new ArrayList<>();
            for (ReservationHotel res: roomModel.getReservations()){
                ReservationHotel reser = new ReservationHotel();
                reser.setId(res.getId());
                reser.setPersonsNumber(res.getPersonsNumber());
                reser.setCheckInDate(res.getCheckInDate());
                reser.setCheckOutDate(res.getCheckOutDate());
                reservationHotels.add(reser);
            }
            roomModel1.setReservations(reservationHotels);
            roomModels.add(roomModel1);
        }
    }

    public void createRooms(long idRoomType, long idHotel, int numRooms){

        Optional<HotelModel> hotelModelOptional = hotelRepository.findById(idHotel);
        Optional<RoomTypeModel> roomTypeModelOptional = roomTypeRepository.findById(idRoomType);
        if (hotelModelOptional.isPresent() && roomTypeModelOptional.isPresent()){
            HotelModel hotel = hotelModelOptional.get();
            RoomTypeModel roomType = roomTypeModelOptional.get();
            for (int r = 1; r <= numRooms; r++){
                RoomModel room = new RoomModel();
                room.setRoomTypeModel(roomType);
                room.setHotel(hotel);
                roomRepository.save(room);
            }

        }
    }

    public List<RoomModel> roomModels(long id){
        Optional<HotelModel> hotelModelOptional = hotelRepository.findById(id);
        HotelModel hotelModel = new HotelModel();
        List<RoomModel> roomModels = new ArrayList<>();
        if (hotelModelOptional.isPresent()){
            HotelModel  hotel = hotelModelOptional.get();

            hotelModel.setId(hotel.getId());
            hotelModel.setName(hotel.getName());
            for (RoomModel roomModel: hotel.getRooms()){
                RoomModel room = new RoomModel();
                room.setId(roomModel.getId());
                room.setReservations(roomModel.getReservations());
                RoomTypeModel roomTypeModel = new RoomTypeModel();
                roomTypeModel.setDescription(roomModel.getRoomTypeModel().getDescription());
                roomTypeModel.setId(roomModel.getRoomTypeModel().getId());
                roomTypeModel.setHasbalcony(roomModel.getRoomTypeModel().isHasbalcony());
                roomTypeModel.setName(roomModel.getRoomTypeModel().getName());
                roomTypeModel.setPlaces(roomModel.getRoomTypeModel().getPlaces());
                room.setRoomTypeModel(roomTypeModel);
                roomModels.add(room);

            }
        }
        return roomModels;
    }

    public Integer returnHotelVacancies(long hotelId, ReservationHotel reservationHotel){
        List<Integer> integerList = new ArrayList<>();
        Optional<HotelModel> hotelModelOptional = hotelRepository.findById(hotelId);
        if (hotelModelOptional.isPresent()){
            HotelModel hotelModel = hotelModelOptional.get();
            for (RoomModel roomModel: hotelModel.getRooms()){
                if (roomModel.getReservations().size()==0){
                    integerList.add(1);
                }else{

                    if (!ifIsReserved(roomModel,reservationHotel)){
                        integerList.add(1);
                    }

                }

            }
        }
        return integerList.size();
    }
}

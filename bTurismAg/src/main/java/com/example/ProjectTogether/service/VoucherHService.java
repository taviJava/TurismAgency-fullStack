package com.example.ProjectTogether.service;

import com.example.ProjectTogether.persistance.model.*;
import com.example.ProjectTogether.repository.ReservationHotelRepository;
import com.example.ProjectTogether.repository.RoomRepository;
import com.example.ProjectTogether.repository.VoucherHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class VoucherHService {
    @Autowired
    private VoucherHRepository voucherHRepository;
    @Autowired
    private ReservationHotelRepository reservationHotelRepository;
    @Autowired
    private RoomRepository roomRepository;
    public void addReservationsH(VoucherH voucherH, String username, String packet){
        List<ReservationHotel> reservationHotels = reservationHotelRepository.findAll();
        ReservationHotel reservationHotel = reservationHotels.get(reservationHotels.size()-1);
        long numberOfDays = DAYS.between(reservationHotel.getCheckInDate().toLocalDate(), reservationHotel.getCheckOutDate().toLocalDate());
        RoomModel roomModel = reservationHotel.getRoom();
        Optional<RoomModel> roomModelOptional = roomRepository.findById(roomModel.getId());
        HotelModel hotelModel = new HotelModel();
        RoomTypeModel roomTypeModel = new RoomTypeModel();
        if (roomModelOptional.isPresent()){
            hotelModel = roomModelOptional.get().getHotel();
            roomTypeModel  =roomModelOptional.get().getRoomTypeModel();
        }
        voucherH.setReservationHotel(reservationHotel);
        voucherH.setUsername(username);
        voucherH.setPacket(Packet.valueOf(packet));
        double totalPrice = calculatePacketPrice(hotelModel.getBasicPrice(),voucherH.getPacket().name(),reservationHotel.getPersonsNumber());
        double addProcent = totalPrice*roomTypeModel.getProcentPrice()/100;
        voucherH.setTotalPrice(numberOfDays*(totalPrice + addProcent));
        voucherHRepository.save(voucherH);
    }
    private double calculatePacketPrice(double price, String packetType, int numPers){
        double totalPrice = price;
        if (packetType.equals("AI")){
            totalPrice = price+((price*20/100)*numPers);
        }if (packetType.equals("FB")){
            totalPrice = price+((price*15/100)*numPers);
        }if (packetType.equals("HB")){
            totalPrice = price+((price*10/100)*numPers);
        }if (packetType.equals("BB")){
            totalPrice = price+((price*5/100)*numPers);
        }
        return totalPrice;
    }
}

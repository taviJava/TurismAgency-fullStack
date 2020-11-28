package com.example.ProjectTogether.service;

import com.example.ProjectTogether.persistance.dto.ReservationfDto;
import com.example.ProjectTogether.persistance.dto.SeatDto;
import com.example.ProjectTogether.persistance.model.*;
import com.example.ProjectTogether.repository.FlightRepository;
import com.example.ProjectTogether.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;
    @Autowired
    private FlightRepository flightRepository;

    public void addReservationsF(ReservationfDto reservation, long id)  {
        ReservationFlight reservationFlight = new ReservationFlight();
        reservationFlight.setDate(reservation.getDate());
        reservationFlight.setDocumentId(reservation.getDocumentId());
        reservationFlight.setFirstName(reservation.getFirstName());
        reservationFlight.setLastName(reservation.getLastName());
        SeatDto seatDto = reservation.getSeat();
        SeatModel seatModel = new SeatModel();
        seatModel.setId(seatDto.getId());
        seatModel.setSeatName(seatDto.getSeatName());
        seatModel.setSeatNumber(seatDto.getSeatNumber());
        reservationFlight.setSeat(seatModel);
        List<Luggage> luggages = new ArrayList<>();
        for(String luggage: reservation.getLuggage()){
            luggages.add(Luggage.valueOf(luggage));
        }
        reservationFlight.setLuggage(luggages);
          VoucherModel voucher = new VoucherModel();
          voucher.setReservationFlight(reservationFlight);
          voucher.setTotalPrice(calculateTotalPrice(id, reservationFlight));
          voucherRepository.save(voucher);

    }
  private double calculateTotalPrice(long id, ReservationFlight reservationFlight){
        double totalPrice = 0;
        Optional<FlightModel> flightModelOptional = flightRepository.findById(id);
        if (flightModelOptional.isPresent()){
            FlightModel flightModel = flightModelOptional.get();
            totalPrice = totalPrice(flightModel, reservationFlight);
        }
        return totalPrice;
  }

  private double totalPrice(FlightModel flightModel, ReservationFlight reservationFlight){
        double totalPrice = flightModel.getSeatPrice();
      System.out.println(totalPrice);
        int vacancies = flightModel.getVacancies();
        int seatsNumber= flightModel.getSeatsRowNumber()*flightModel.getRowsNumber();
        double check =(double) seatsNumber/vacancies;
        if (check <= 1.20   ){
            totalPrice = totalPrice + totalPrice*0/100;
        }
        if (check <= 1.66 && check > 1.20){
            totalPrice = totalPrice + totalPrice*2/100;
        }
        if (check <= 2.5 && check > 1.66){
            totalPrice = totalPrice + totalPrice*3/100;
        }
       if (check <= 5 && check > 2.5){
          totalPrice = totalPrice + totalPrice*4/100;
      }
      if ( check > 5){
          totalPrice = totalPrice + totalPrice*5/100;
      }
      flightModel.setSeatPrice(Math.round(totalPrice));
      flightRepository.save(flightModel);
      List<String> luggages = new ArrayList<>();
      for (Luggage luggage: reservationFlight.getLuggage()){
          luggages.add(luggage.name());
      }
      for (String lug: luggages){
          if (lug.equals("HB")){
              totalPrice = totalPrice + 10;
          }
          if (lug.equals("ML")){
              totalPrice = totalPrice + 20;
          }
          if (lug.equals("HL")){
              totalPrice = totalPrice + 30;
          }
      }
    return (Math.round(totalPrice));
  }


}

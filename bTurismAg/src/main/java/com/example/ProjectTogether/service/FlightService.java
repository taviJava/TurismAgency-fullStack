package com.example.ProjectTogether.service;

import com.example.ProjectTogether.model.FlightModel;
import com.example.ProjectTogether.model.ReservationFlight;
import com.example.ProjectTogether.model.SeatModel;
import com.example.ProjectTogether.repository.FlightRepository;
import com.example.ProjectTogether.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private SeatRepository seatRepository;

    public void createFlight(FlightModel flight){
        flight.setVacancies(flight.getRowsNumber()*flight.getSeatsRowNumber());
        flightRepository.save(flight);
            for (int r = 1; r<=flight.getRowsNumber() ; r++){

                for (int s = 1; s<=flight.getSeatsRowNumber();s++){
                    String seatName = createSeatName(s)+r;
                    SeatModel seat = new SeatModel();
                    seat.setSeatName(seatName);
                    seat.setSeatNumber(r);
                    seat.setFlight(flight);
                    seatRepository.save(seat);
                }
            }


    }

    private String createSeatName(int rowNumber){
       char x = 'A';
       for (int i =1; i<rowNumber; i++){
           x = (char) (x + 1);
       }
      String name= ""+x;
       return name;
    }

    private List<SeatModel> getSeatsByFlight(long id){
        return seatRepository.findAllByFlight_Id(id);
    }
  public List<SeatModel> listLeft(long id){
        Optional<FlightModel> flightModelOptional = flightRepository.findById(id);
      List<SeatModel> seatModelsLeft = new ArrayList<>();
        if (flightModelOptional.isPresent()){
            List<SeatModel> seatModelsAll = getSeatsByFlight(id);
            for (SeatModel seatModel: seatModelsAll){
             int i = flightModelOptional.get().getRowsNumber()/2;
             if (seatModel.getSeatNumber()<=i){
                 SeatModel seat = new SeatModel();
                 seat.setId(seatModel.getId());
                 seat.setSeatNumber(seatModel.getSeatNumber());
                 seat.setSeatName(seatModel.getSeatName());
                 if (seatModel.getReservation() != null){
                 ReservationFlight res = new ReservationFlight();
                 res.setDate(seatModel.getReservation().getDate());
                 res.setId(seatModel.getId());
                 seat.setReservation(res);
                 }
                 seatModelsLeft.add(seat);
             }
            }
        }
return seatModelsLeft;
  }


public List<SeatModel> seatModelsRight(long id){
    Optional<FlightModel> flightModelOptional = flightRepository.findById(id);
    List<SeatModel> seatModelsRight = new ArrayList<>();
    if (flightModelOptional.isPresent()) {
        List<SeatModel> seatModelsAll = getSeatsByFlight(id);
        for (SeatModel seatModel : seatModelsAll) {
            int i = flightModelOptional.get().getRowsNumber() / 2;
            if (seatModel.getSeatNumber() > i) {
                SeatModel seat = new SeatModel();
                seat.setId(seatModel.getId());
                seat.setSeatNumber(seatModel.getSeatNumber());
                seat.setSeatName(seatModel.getSeatName());
                if (seatModel.getReservation() != null) {
                    ReservationFlight res = new ReservationFlight();
                    res.setDate(seatModel.getReservation().getDate());
                    res.setId(seatModel.getId());
                    seat.setReservation(res);
                }
                seatModelsRight.add(seat);
            }
        }
    }
    return seatModelsRight;
}
}

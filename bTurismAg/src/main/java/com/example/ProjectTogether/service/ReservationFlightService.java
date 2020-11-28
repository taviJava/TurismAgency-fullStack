package com.example.ProjectTogether.service;

import com.example.ProjectTogether.persistance.dto.ReservationfDto;
import com.example.ProjectTogether.persistance.dto.SeatDto;
import com.example.ProjectTogether.persistance.model.FlightModel;
import com.example.ProjectTogether.persistance.model.Luggage;
import com.example.ProjectTogether.persistance.model.ReservationFlight;
import com.example.ProjectTogether.persistance.model.SeatModel;
import com.example.ProjectTogether.repository.FlightRepository;
import com.example.ProjectTogether.repository.ReservationFlightRepository;
import com.example.ProjectTogether.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationFlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private ReservationFlightRepository reservationFlightRepository;

    private boolean ifIsOccupated(SeatModel seat) {
        if (seat.getFlight().getDepartureDay() != null) {
            return true;
        }
        return false;
    }

    public void saveReservation(ReservationfDto reservation, long id, int numPers) {
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
        Optional<FlightModel> flightModelOptional = flightRepository.findById(id);
        if (flightModelOptional.isPresent()) {
            FlightModel flight = flightModelOptional.get();
            if (flight.getVacancies() > numPers) {
                for (int i = 0; i < numPers; i++) {
                    for (SeatModel seat : flight.getSeats()) {
                        if (!ifIsOccupated(seat)) {
                            seat.setReservation(reservationFlight);
                            flight.setVacancies(flight.getVacancies() - 1);
                            seatRepository.save(seat);
                            flightRepository.save(flight);
                            break;
                        }
                    }
                }
            }
        }
    }





}

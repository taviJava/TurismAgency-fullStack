package com.example.ProjectTogether.service;

import com.example.ProjectTogether.model.FlightModel;
import com.example.ProjectTogether.model.HotelModel;
import com.example.ProjectTogether.model.ReservationFlight;
import com.example.ProjectTogether.model.SeatModel;
import com.example.ProjectTogether.repository.FlightRepository;
import com.example.ProjectTogether.repository.ReservationFlightRepository;
import com.example.ProjectTogether.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void saveReservation(ReservationFlight reservation, long id, int numPers) {
        Optional<FlightModel> flightModelOptional = flightRepository.findById(id);
        if (flightModelOptional.isPresent()) {
            FlightModel flight = flightModelOptional.get();
            if (flight.getVacancies() > numPers) {
                for (int i = 0; i < numPers; i++) {
                    for (SeatModel seat : flight.getSeats()) {
                        if (!ifIsOccupated(seat)) {
                            seat.setReservation(reservation);
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

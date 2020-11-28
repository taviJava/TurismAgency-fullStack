package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.persistance.dto.FlightDto;
import com.example.ProjectTogether.persistance.dto.ReservationfDto;
import com.example.ProjectTogether.persistance.model.*;
import com.example.ProjectTogether.repository.FlightRepository;
import com.example.ProjectTogether.repository.ReservationFlightRepository;
import com.example.ProjectTogether.service.FlightService;
import com.example.ProjectTogether.service.ReservationFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightService flightService;
    @Autowired
    private ReservationFlightService reservationFlightService;
    @Autowired
    private ReservationFlightRepository reservationFlightRepository;

    @PostMapping("/flights")
    public void addFlight(@RequestBody FlightDto flightDto){
        flightService.createFlight(flightDto);
    }

    @GetMapping("/flights")
    public List<FlightDto> getFlights(){
       return flightService.getAll();
    }

    @GetMapping("/flights/{id}")
    public FlightDto getById(@PathVariable(name = "id") Long idFlight) {
        return flightService.getOne(idFlight);
    }
    @PutMapping("/flights/{id}/{numPers}")  //numPers persoanele care vor sa rezerve bilete la zborul respectiv
    public void saveReservation(@RequestBody ReservationfDto reservation, @PathVariable(name = "id") Long idFlight, @PathVariable(name = "numPers") int numPers){
        reservationFlightService.saveReservation(reservation,idFlight,numPers);
    }

    @PutMapping("/flights")
    public void updateFlight(@RequestBody FlightModel flightModel){
        FlightModel updatedFlight = flightRepository.findById(flightModel.getId()).orElse(null);
        updatedFlight.setName(flightModel.getName());
        updatedFlight.setVacancies(flightModel.getVacancies());
        updatedFlight.setDepartureDay(flightModel.getDepartureDay());
        updatedFlight.setDepartureHour(flightModel.getDepartureHour());
        updatedFlight.setReturnDay(flightModel.getReturnDay());
        updatedFlight.setReturnHour(flightModel.getReturnHour());
        updatedFlight.setAirportArrival(flightModel.getAirportArrival());
        updatedFlight.setAirportDeparture(flightModel.getAirportDeparture());
        flightRepository.save(updatedFlight);
    }

    @DeleteMapping("/flights/{id}")
    public void deleteCity(@PathVariable (name = "id") Long id){
        flightRepository.deleteById(id);
    }
    @GetMapping("/flights/seatsL/{id}")
    public List<SeatModel> seatModelsL(@PathVariable(name = "id") Long idFlight){
        return flightService.listLeft(idFlight);
    }
    @GetMapping("/flights/seatsR/{id}")
    public List<SeatModel> seatModelsR(@PathVariable(name = "id") Long idFlight){
        return flightService.seatModelsRight(idFlight);
    }
    @PostMapping("/flight/reserve/seat/")
    public void reserveSeat(@RequestBody ReservationFlight reservationFlight){
        System.out.println("test");
        reservationFlightRepository.save(reservationFlight);
    }
    @PutMapping("/flights/vacancies/{id}/{vacancies}")
    public void updateVacancies(@PathVariable(name = "id") Long idFlight, @PathVariable(name = "vacancies") int vacancies){
        flightService.setVacancies(idFlight,vacancies);
    }
}

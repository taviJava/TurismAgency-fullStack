package com.example.ProjectTogether.controller;


import com.example.ProjectTogether.model.*;
import com.example.ProjectTogether.repository.FlightRepository;
import com.example.ProjectTogether.service.FlightService;
import com.example.ProjectTogether.service.ReservationFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
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

    @PostMapping("/flights")
    public void addFlight(@RequestBody FlightModel flightModel){
        flightService.createFlight(flightModel);
    }

    @GetMapping("/flights")
    public List<FlightModel> getFlights(){
        List<FlightModel> flightModels = new ArrayList<>();
        for (FlightModel flightModel: flightRepository.findAll() ){
            FlightModel flight = new FlightModel();
            flight.setId(flightModel.getId());
            flight.setName(flightModel.getName());
            flight.setVacancies(flightModel.getVacancies());
            flight.setDepartureDay(flightModel.getDepartureDay());
            flight.setReturnDay(flightModel.getReturnDay());
            flight.setDepartureHour(flightModel.getDepartureHour());
            flight.setArriveHour(flightModel.getArriveHour());
            flight.setRowsNumber(flightModel.getRowsNumber());
            flight.setSeats(flightModel.getSeats());
            AirportModel airportDep = new AirportModel();
            airportDep.setName(flightModel.getAirportDeparture().getName());
            CityModel cityModel1 = new CityModel();
            cityModel1.setName(flightModel.getAirportDeparture().getCityModel().getName());
            airportDep.setCityModel(cityModel1);
            AirportModel airportArr = new AirportModel();
            CityModel cityModel2 = new CityModel();
            cityModel2.setName(flightModel.getAirportArrival().getCityModel().getName());
            airportArr.setName(flightModel.getAirportArrival().getName());
            airportArr.setCityModel(cityModel2);
            flight.setAirportDeparture(airportDep);
            flight.setAirportArrival(airportArr);
            flightModels.add(flight);
        }

        return flightModels;
    }

    @GetMapping("/flights/{id}")
    public FlightModel getById(@PathVariable(name = "id") Long idFlight) {
        Optional<FlightModel> flightModelOptional = flightRepository.findById(idFlight);
        FlightModel flight = new FlightModel();
        if (flightModelOptional.isPresent()){
            FlightModel  flightModel = flightModelOptional.get();
            flight.setId(flightModel.getId());
            flight.setName(flightModel.getName());
            flight.setVacancies(flightModel.getVacancies());
            flight.setDepartureDay(flightModel.getDepartureDay());
            flight.setReturnDay(flightModel.getReturnDay());
            flight.setSeats(flightModel.getSeats());
            flight.setDepartureHour(flightModel.getDepartureHour());
            flight.setArriveHour(flightModel.getArriveHour());
            flight.setRowsNumber(flightModel.getRowsNumber());
            flight.setSeatsRowNumber(flightModel.getSeatsRowNumber());
            AirportModel airportDep = new AirportModel();
            airportDep.setName(flightModel.getAirportDeparture().getName());
            CityModel cityModel1 = new CityModel();
            cityModel1.setName(flightModel.getAirportDeparture().getCityModel().getName());
            airportDep.setCityModel(cityModel1);
            AirportModel airportArr = new AirportModel();
            CityModel cityModel2 = new CityModel();
            cityModel2.setName(flightModel.getAirportArrival().getCityModel().getName());
            airportArr.setName(flightModel.getAirportArrival().getName());
            airportArr.setCityModel(cityModel2);
            flight.setAirportDeparture(airportDep);
            flight.setAirportArrival(airportArr);
        }
        return flight;
    }
    @PutMapping("/flights/{id}/{numPers}")  //numPers persoanele care vor sa rezerve bilete la zborul respectiv
    public void saveReservation(@RequestBody ReservationFlight reservation,@PathVariable(name = "id") Long idFlight,@PathVariable(name = "numPers") int numPers){
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

}

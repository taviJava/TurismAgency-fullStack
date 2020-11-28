package com.example.ProjectTogether.service;

import com.example.ProjectTogether.persistance.dto.*;
import com.example.ProjectTogether.persistance.model.*;
import com.example.ProjectTogether.repository.AirportRepository;
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

    @Autowired
    private AirportRepository airportRepository;

    public void createFlight(FlightDto flightDto){
        FlightModel flightModel = new FlightModel();
        flightModel.setName(flightDto.getName());
        flightModel.setArriveHour(flightDto.getArriveHour());
        flightModel.setDepartureHour(flightDto.getDepartureHour());
        flightModel.setReturnDay(flightDto.getReturnDay());
        flightModel.setDepartureDay(flightDto.getDepartureDay());
        flightModel.setSeatPrice(flightDto.getSeatPrice());
        Optional<AirportModel> airportModelOptionalArr = airportRepository.findById(flightDto.getAirportArrival().getId());
        if (airportModelOptionalArr.isPresent()){
            AirportModel airportArrival = airportModelOptionalArr.get();
                    flightModel.setAirportArrival(airportArrival);
        }
        Optional<AirportModel> airportModelOptionalDep = airportRepository.findById(flightDto.getAirportDeparture().getId());
        if (airportModelOptionalDep.isPresent()){
            AirportModel airportModel = airportModelOptionalDep.get();
            flightModel.setAirportDeparture(airportModel);
        }

        flightModel.setVacancies(flightModel.getRowsNumber()*flightModel.getSeatsRowNumber());
        flightRepository.save(flightModel);
            for (int r = 1; r<=flightModel.getRowsNumber() ; r++){

                for (int s = 1; s<=flightModel.getSeatsRowNumber();s++){
                    String seatName = createSeatName(s)+r;
                    SeatModel seat = new SeatModel();
                    seat.setSeatName(seatName);
                    seat.setSeatNumber(r);
                    seat.setFlight(flightModel);
                    seatRepository.save(seat);
                }
            }
    }
public void delete(long id){
        airportRepository.deleteById(id);
}

public List<FlightDto> getAll(){
    List<FlightDto> flightModels = new ArrayList<>();
    for (FlightModel flightModel: flightRepository.findAll() ){
        FlightDto flight = new FlightDto();
        flight.setId(flightModel.getId());
        flight.setName(flightModel.getName());
        flight.setVacancies(flightModel.getVacancies());
        flight.setDepartureDay(flightModel.getDepartureDay());
        flight.setReturnDay(flightModel.getReturnDay());
        flight.setDepartureHour(flightModel.getDepartureHour());
        flight.setArriveHour(flightModel.getArriveHour());
        flight.setRowsNumber(flightModel.getRowsNumber());
        List<SeatDto> seatDtos = new ArrayList<>();
        for (SeatModel seatModel:flightModel.getSeats() ){
            SeatDto seatDto = new SeatDto();
            seatDto.setId(seatModel.getId());
            seatDto.setSeatName(seatModel.getSeatName());
            seatDto.setSeatNumber(seatModel.getSeatNumber());
           seatDtos.add(seatDto);
        }
        flight.setSeats(seatDtos);
        flight.setSeatPrice(flightModel.getSeatPrice());
        AirportDto airportDep = new AirportDto();
        airportDep.setName(flightModel.getAirportDeparture().getName());
        CityDto cityDtoDep= new CityDto();
        cityDtoDep.setName(flightModel.getAirportDeparture().getCityModel().getName());
        airportDep.setCityModel(cityDtoDep);
        CityDto cityDtoArr = new CityDto();
        cityDtoArr.setName(flightModel.getAirportArrival().getCityModel().getName());
        AirportDto airportArr = new AirportDto();
        airportArr.setName(flightModel.getAirportArrival().getName());
        airportArr.setCityModel(cityDtoArr);
        flight.setAirportArrival(airportArr);
        flight.setAirportDeparture(airportDep);
        flightModels.add(flight);
    }

    return flightModels;
    }

    public FlightDto getOne(long id){
       Optional <FlightModel> flightModelOpt = flightRepository.findById(id);
       FlightDto flight = new FlightDto();
       if (flightModelOpt.isPresent()){
           FlightModel flightModel = flightModelOpt.get();
           flight.setId(flightModel.getId());
           flight.setName(flightModel.getName());
           flight.setVacancies(flightModel.getVacancies());
           flight.setDepartureDay(flightModel.getDepartureDay());
           flight.setReturnDay(flightModel.getReturnDay());
           flight.setDepartureHour(flightModel.getDepartureHour());
           flight.setArriveHour(flightModel.getArriveHour());
           flight.setRowsNumber(flightModel.getRowsNumber());
           List<SeatDto> seatDtos = new ArrayList<>();
           for (SeatModel seatModel:flightModel.getSeats() ){
               SeatDto seatDto = new SeatDto();
               seatDto.setId(seatModel.getId());
               seatDto.setSeatName(seatModel.getSeatName());
               seatDto.setSeatNumber(seatModel.getSeatNumber());
               seatDtos.add(seatDto);
           }
           flight.setSeats(seatDtos);
           flight.setSeatPrice(flightModel.getSeatPrice());
           AirportDto airportDep = new AirportDto();
           airportDep.setName(flightModel.getAirportDeparture().getName());
           CityDto cityDtoDep= new CityDto();
           cityDtoDep.setName(flightModel.getAirportDeparture().getCityModel().getName());
           airportDep.setCityModel(cityDtoDep);
           CityDto cityDtoArr = new CityDto();
           cityDtoArr.setName(flightModel.getAirportArrival().getCityModel().getName());
           AirportDto airportArr = new AirportDto();
           airportArr.setName(flightModel.getAirportArrival().getName());
           airportArr.setCityModel(cityDtoArr);
           flight.setAirportArrival(airportArr);
           flight.setAirportDeparture(airportDep);
       }
       return flight;
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
    public void setVacancies(long id, int vacancies){
        Optional<FlightModel> flightModelOptional = flightRepository.findById(id);
        if (flightModelOptional.isPresent()){
            FlightModel  flightModel  = flightModelOptional.get();
            flightModel.setVacancies(flightModel.getVacancies()-vacancies);
            flightRepository.save(flightModel);
        }
    }
}

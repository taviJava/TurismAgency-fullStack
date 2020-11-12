package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.model.AirportModel;
import com.example.ProjectTogether.model.CityModel;
import com.example.ProjectTogether.model.ParticipantModel;
import com.example.ProjectTogether.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class AirportController {

    @Autowired
    private AirportRepository airportRepository;

    @PostMapping("/airports")
    public void addAirport(@RequestBody AirportModel airportModel) {
        System.out.println(airportModel.getCityModel().getName());
        airportRepository.save(airportModel);
    }

    @GetMapping("/airports")
    public List<AirportModel> getAirports() {
        List<AirportModel> airportModels = new ArrayList<>();
        for (AirportModel airportModel: airportRepository.findAll()){
            AirportModel airport = new AirportModel();
            airport.setId(airportModel.getId());
            airport.setName(airportModel.getName());
            CityModel cityModel = new CityModel();
            cityModel.setName(airportModel.getCityModel().getName());
            airport.setCityModel(cityModel);
            airportModels.add(airport);
        }

        return airportModels;
    }

    @GetMapping("/airports/{id}")
    public AirportModel getById(@PathVariable(name = "id") Long idAirport) {
        return airportRepository.findById(idAirport).orElse(null);
    }

    @PutMapping("/airports")
    public void updateAirport(@RequestBody AirportModel airportModel) {
        AirportModel updatedAirport = airportRepository.findById(airportModel.getId()).orElse(null);
        updatedAirport.setName(airportModel.getName());
        updatedAirport.setCityModel(airportModel.getCityModel());
        airportRepository.save(updatedAirport);
    }

    @DeleteMapping("/airports/{id}")
    public void deleteAirport(@PathVariable(name = "id") Long id) {
        airportRepository.deleteById(id);
    }
}

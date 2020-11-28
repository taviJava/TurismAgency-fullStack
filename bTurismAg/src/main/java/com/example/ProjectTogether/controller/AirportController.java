package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.persistance.dto.AirportDto;
import com.example.ProjectTogether.persistance.model.AirportModel;
import com.example.ProjectTogether.persistance.model.CityModel;
import com.example.ProjectTogether.repository.AirportRepository;
import com.example.ProjectTogether.service.AiroportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class AirportController {

    @Autowired
    private AiroportService airoportService;

    @PostMapping("/airports")
    public void addAirport(@RequestBody AirportDto airportDto) {
        airoportService.save(airportDto);
    }

    @GetMapping("/airports")
    public List<AirportDto> getAirports() {
      return   airoportService.getAll();
    }

    @GetMapping("/airports/{id}")
    public AirportDto getById(@PathVariable(name = "id") Long idAirport) {
        return airoportService.getOne(idAirport);
    }

    @PutMapping("/airports")
    public void updateAirport(@RequestBody AirportDto airportDto) {
        airoportService.update(airportDto);
    }

    @DeleteMapping("/airports/{id}")
    public void deleteAirport(@PathVariable(name = "id") Long id) {
        airoportService.delete(id);
    }
}

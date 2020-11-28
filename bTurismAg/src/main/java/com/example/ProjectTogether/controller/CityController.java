package com.example.ProjectTogether.controller;


import com.example.ProjectTogether.persistance.dto.CityDto;
import com.example.ProjectTogether.persistance.model.CityModel;
import com.example.ProjectTogether.persistance.model.CountryModel;
import com.example.ProjectTogether.repository.CityRepository;
import com.example.ProjectTogether.repository.HotelRepository;
import com.example.ProjectTogether.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CityController {

   @Autowired
   private CityService cityService;

    @PostMapping("/cities")
    public void addCity(@RequestBody CityDto cityDto){
        cityService.save(cityDto);
    }

    @GetMapping("/cities")
    public List<CityDto> getCities(){
      return cityService.getAll();
    }


    @GetMapping("/cities/{id}")
    public CityDto getById(@PathVariable(name = "id") Long idCity) {
   return cityService.getOne(idCity);
    }

    @PutMapping("/cities")
    public void updateCity(@RequestBody CityDto cityDto){
        cityService.update(cityDto);
    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable (name = "id") Long id){
        cityService.delete(id);
    }

}

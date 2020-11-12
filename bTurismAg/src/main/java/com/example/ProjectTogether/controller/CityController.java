package com.example.ProjectTogether.controller;


import com.example.ProjectTogether.model.CityModel;
import com.example.ProjectTogether.model.CountryModel;
import com.example.ProjectTogether.model.ParticipantModel;
import com.example.ProjectTogether.repository.CityRepository;
import com.example.ProjectTogether.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CityController {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private HotelRepository hotelRepository;

    @PostMapping("/cities")
    public void addCity(@RequestBody CityModel cityModel){
        cityRepository.save(cityModel);
    }

    @GetMapping("/cities")
    public List<CityModel> getCities(){
        List<CityModel> cityModels = new ArrayList<>();
        for (CityModel cityModel: cityRepository.findAll()){
            CityModel city = new CityModel();
            city.setId(cityModel.getId());
            city.setName(cityModel.getName());
            CountryModel country = new CountryModel();
            country.setId(cityModel.getCountryModel().getId());
            country.setName(cityModel.getCountryModel().getName());
            city.setCountryModel(country);
            cityModels.add(city);
        }
        return  cityModels;
    }


    @GetMapping("/cities/{id}")
    public CityModel getById(@PathVariable(name = "id") Long idCity) {
        Optional<CityModel> cityModelOptional = cityRepository.findById(idCity);
        CityModel city = new CityModel();
        if (cityModelOptional.isPresent()){
            CityModel cityModel = cityModelOptional.get();
            city.setId(cityModel.getId());
            city.setName(cityModel.getName());
        }
        return city;
    }

    @PutMapping("/cities")
    public void updateCity(@RequestBody CityModel cityModel){
        CityModel updatedCity = cityRepository.findById(cityModel.getId()).orElse(null);
        updatedCity.setName(cityModel.getName());
        cityRepository.save(updatedCity);
    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable (name = "id") Long id){
        cityRepository.deleteById(id);
    }

}

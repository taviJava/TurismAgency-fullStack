package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.persistance.dto.CountryDto;
import com.example.ProjectTogether.persistance.model.CountryModel;
import com.example.ProjectTogether.repository.CountryRepository;
import com.example.ProjectTogether.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class CountryController {
  @Autowired
  private CountryService countryService;

  @PostMapping("/country")
  public void addCountry(@RequestBody CountryDto countryDto) {
    countryService.save(countryDto);
  }
  @DeleteMapping("/country/{id}")
  public void deleteCountry(@PathVariable(name = "id") Long id) {
    countryService.delete(id);
  }

  @GetMapping("/country")
  public List<CountryDto> getCountries() {
    return countryService.getAll();
  }

  @GetMapping("/country/{id}")
  public CountryDto getCountryById(@PathVariable(name = "id") Long id) {
    return countryService.getOne(id);
  }
  @PutMapping("/country")
  public void update(@RequestBody CountryDto countryDto){
    countryService.update(countryDto);
  }
}

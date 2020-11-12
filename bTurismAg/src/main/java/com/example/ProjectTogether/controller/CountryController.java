package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.model.CountryModel;
import com.example.ProjectTogether.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class CountryController {
  @Autowired
  private CountryRepository countryRepository;

  @PostMapping("/country")
  public void addCountry(@RequestBody CountryModel countryModel) {
    countryRepository.save(countryModel);

  }

  @DeleteMapping("/country/{id}")
  public void deleteCountry(@PathVariable(name = "id") Long id) {
    countryRepository.deleteById(id);
  }

  @GetMapping("/country")
  public List<CountryModel> getCountries() {
    return countryRepository.findAll();
  }

  @GetMapping("/country/{id}")
  public CountryModel getCountryById(@PathVariable(name = "id") Long id) {
    return countryRepository.findById(id).orElse(null);
  }
  @PutMapping("/country")
  public void update(@RequestBody CountryModel countryModel){
    CountryModel countryUpdate=countryRepository.findById(countryModel.getId()).orElse(null);
    countryUpdate.setName(countryModel.getName());
    countryUpdate.setContinentModel(countryModel.getContinentModel());
    countryRepository.save(countryModel);
  }
}

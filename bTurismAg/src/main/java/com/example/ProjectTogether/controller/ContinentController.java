package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.model.ContinentModel;
import com.example.ProjectTogether.repository.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ContinentController {
  @Autowired
  private ContinentRepository continentRepository;

  @PostMapping("/continent")
  public void addContinent(@RequestBody ContinentModel continentModel) {
    continentRepository.save(continentModel);
  }

  @DeleteMapping("/continent/{id}")
  public void deleteContinent(@PathVariable(name = "id") Long id) {
    continentRepository.deleteById(id);
  }

  @GetMapping("/continent")
  public List<ContinentModel> getContinents() {
    return continentRepository.findAll();
  }

  @GetMapping("/continent/{id}")
  public ContinentModel getContinentById(@PathVariable(name = "id") Long id) {
    return continentRepository.findById(id).orElse(null);
  }
  @PutMapping("/continent")
  public void updateContinent(@RequestBody ContinentModel continentModel){
    ContinentModel updatedContinent = continentRepository.findById(continentModel.getId()).orElse(null);
    updatedContinent.setName(continentModel.getName());
    updatedContinent.setCountryModelList(continentModel.getCountryModelList());
    continentRepository.save(continentModel);
  }
}

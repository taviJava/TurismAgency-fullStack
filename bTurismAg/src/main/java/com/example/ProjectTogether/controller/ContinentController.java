package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.persistance.dto.ContinentDto;
import com.example.ProjectTogether.persistance.model.ContinentModel;
import com.example.ProjectTogether.repository.ContinentRepository;
import com.example.ProjectTogether.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ContinentController {
  @Autowired
  private ContinentService continentService;

  @PostMapping("/continent")
  public void addContinent(@RequestBody ContinentDto continentDto) {
    continentService.save(continentDto);
  }

  @DeleteMapping("/continent/{id}")
  public void deleteContinent(@PathVariable(name = "id") Long id) {
    continentService.delete(id);
  }

  @GetMapping("/continent")
  public List<ContinentDto> getContinents() {
    return continentService.getAll();
  }

  @GetMapping("/continent/{id}")
  public ContinentDto getContinentById(@PathVariable(name = "id") Long id) {
    return continentService.getContinent(id);
  }
  @PutMapping("/continent")
  public void updateContinent(@RequestBody ContinentDto continentDto){
  continentService.update(continentDto);
  }
}

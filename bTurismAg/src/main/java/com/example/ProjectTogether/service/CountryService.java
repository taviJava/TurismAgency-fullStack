package com.example.ProjectTogether.service;

import com.example.ProjectTogether.persistance.dto.ContinentDto;
import com.example.ProjectTogether.persistance.dto.CountryDto;
import com.example.ProjectTogether.persistance.model.ContinentModel;
import com.example.ProjectTogether.persistance.model.CountryModel;
import com.example.ProjectTogether.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public void save(CountryDto countryDto){
        CountryModel countryModel = new CountryModel();
        countryModel.setName(countryDto.getName());
        ContinentModel continentModel = new ContinentModel();
        continentModel.setId(countryDto.getContinentModel().getId());
        continentModel.setName(countryDto.getContinentModel().getName());
        countryModel.setContinentModel(continentModel);
        countryRepository.save(countryModel);
    }
    public void update(CountryDto countryDto){
        Optional<CountryModel> optionalCountryModel = countryRepository.findById(countryDto.getId());
        if (optionalCountryModel.isPresent()){
            CountryModel countryModel = optionalCountryModel.get();
            countryModel.setName(countryDto.getName());
            ContinentModel continentModel = new ContinentModel();
            continentModel.setId(countryDto.getContinentModel().getId());
            continentModel.setName(countryDto.getContinentModel().getName());
            countryModel.setContinentModel(continentModel);
            countryRepository.save(countryModel);
        }
    }
    public void delete(long id){
        countryRepository.deleteById(id);
    }
    public List<CountryDto> getAll(){
        List<CountryModel> countryModels = countryRepository.findAll();
        List<CountryDto> countryDtos = new ArrayList<>();
        for (CountryModel countryModel: countryModels){
            CountryDto countryDto = new CountryDto();
            countryDto.setId(countryModel.getId());
            countryDto.setName(countryModel.getName());
            ContinentDto continentDto = new ContinentDto();
            continentDto.setId(countryModel.getContinentModel().getId());
            continentDto.setName(countryModel.getContinentModel().getName());
            countryDto.setContinentModel(continentDto);
            countryDtos.add(countryDto);

        }
        return countryDtos;
    }
    public CountryDto getOne(long id){
        Optional<CountryModel> countryModelOptional = countryRepository.findById(id);
        CountryDto countryDto = new CountryDto();
        if (countryModelOptional.isPresent()){
            CountryModel countryModel = countryModelOptional.get();
            countryDto.setId(countryModel.getId());
            countryDto.setName(countryModel.getName());
            ContinentDto continentDto = new ContinentDto();
            continentDto.setId(countryModel.getContinentModel().getId());
            continentDto.setName(countryModel.getContinentModel().getName());
            countryDto.setContinentModel(continentDto);
        }
        return countryDto;
    }
}

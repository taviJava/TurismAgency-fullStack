package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.model.ParticipantModel;
import com.example.ProjectTogether.model.TripModel;
import com.example.ProjectTogether.repository.ParticipantRepository;
import com.example.ProjectTogether.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class TripController {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @GetMapping("/trips")
    public List<TripModel> getTrips(){
        return  tripRepository.findAll();
    }

    @PostMapping("/trips")
    public void addTrip(@RequestBody TripModel tripModel){
        tripRepository.save(tripModel);
    }

    @PutMapping("/trips")
    public void updateTrip(@RequestBody TripModel tripModel){
        TripModel tripModel1 = tripRepository.findById(tripModel.getId()).orElse(null);

        tripModel1.setDepartureDate(tripModel.getDepartureDate());
        tripModel1.setReturnDate(tripModel.getReturnDate());
        tripModel1.setNumberOfDays(tripModel.getNumberOfDays());
        tripModel1.setParticipantModels(tripModel.getParticipantModels());
        tripModel1.setPriceForAdults(tripModel.getPriceForAdults());
        tripModel1.setPriceForChildren(tripModel.getPriceForChildren());
        tripModel1.setPromoted(tripModel.isPromoted());
        tripRepository.save(tripModel1);
    }

    @GetMapping("/trips/{id}")
    public TripModel findById(@PathVariable(name = "id")Long idTrip){
        return tripRepository.findById(idTrip).orElse(null);
    }

    @DeleteMapping("/trips/{id}")
    public void delete(@PathVariable(name = "id")Long id){
        tripRepository.deleteById(id);
    }

    //primesc id-ul lui trip si adaug continutul de la obiectul Participant
    @PostMapping("/trips/assignparticipant/{id}")
    public void assigParticipantToTrip(@PathVariable(name = "id") Long tripId,
                                       @RequestBody List<ParticipantModel> participantModels){
        TripModel tripModel = tripRepository.findById(tripId).orElse(null);
        tripModel.getParticipantModels().addAll(participantModels);
        tripRepository.save(tripModel);
    }
    @PostMapping("/trips/unassignparticipant/{id}")
    public void unassignParticipantToTrip(@PathVariable(name = "id") Long roleId,
                                          @RequestBody List<ParticipantModel> participantModels) {
        TripModel tripModel= tripRepository.findById(roleId).orElse(null);
        tripModel.getParticipantModels().removeIf(a->participantModels.stream().
                filter(b->b.getId()==a.getId()).collect(Collectors.toList()).size()>0);
        tripRepository.save(tripModel);
    }

    @GetMapping("/trips/unassignparticipant/{id}")
    public List<ParticipantModel> getUnassignedParticipants(@PathVariable(name = "id") Long tripId){
        return participantRepository.getUnassignParticipants(tripId).orElse(null);
    }
}

package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.persistance.model.ReservationHotel;
import com.example.ProjectTogether.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ReservationHController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reservation/hotel/{username}")
    public void reserve(@RequestBody ReservationHotel reservationHotel, @PathVariable(name = "username") String username){

    }
}

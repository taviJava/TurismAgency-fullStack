package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.persistance.dto.ReservationfDto;
import com.example.ProjectTogether.persistance.model.ReservationFlight;
import com.example.ProjectTogether.repository.VoucherRepository;
import com.example.ProjectTogether.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class VoucherController {
    @Autowired
    private VoucherService voucherService;
    @PostMapping("/voucher/{id}")
    public void save(@RequestBody ReservationfDto reservationfDto, @PathVariable(name = "id") Long id) throws InterruptedException {
        voucherService.addReservationsF(reservationfDto,id);
    }

}

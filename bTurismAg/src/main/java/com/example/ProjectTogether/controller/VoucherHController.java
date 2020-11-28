package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.persistance.model.ReservationHotel;
import com.example.ProjectTogether.persistance.model.VoucherH;
import com.example.ProjectTogether.persistance.model.files.ResponseMessage;
import com.example.ProjectTogether.repository.VoucherHRepository;
import com.example.ProjectTogether.service.ReservationService;
import com.example.ProjectTogether.service.VoucherHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class VoucherHController {
    @Autowired
    private VoucherHService voucherHService;
    @Autowired
    private VoucherHRepository voucherRepository;

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reserve/hotel/voucher/{id}/{dateIn}/{dateOut}/{numPers}/{username}/{packet}")
    public ResponseMessage reserve(@RequestBody VoucherH voucherH, @PathVariable(name = "id") Long id, @PathVariable(name = "dateIn") String dateIn, @PathVariable(name = "dateOut") String dateOut, @PathVariable(name = "numPers") int numPers, @PathVariable(name = "username") String username, @PathVariable(name = "packet") String packet) throws InterruptedException {
        ReservationHotel reservation = new ReservationHotel();
        reservation.setCheckInDate(java.sql.Date.valueOf(dateIn));
        System.out.println(dateOut);
        reservation.setCheckOutDate(java.sql.Date.valueOf(dateOut));
        reservation.setPersonsNumber(numPers);
        return new ResponseMessage(reservationService.reserve(reservation,id, voucherH,username,packet));
    }

    @GetMapping("/voucherh/{id}")
    public VoucherH getVoucher(@PathVariable(name = "id") long id){
        System.out.println("test");
        Optional<VoucherH> voucherH = voucherRepository.findById(id);
        VoucherH voucherh = new VoucherH();
        if (voucherH.isPresent()){
            voucherh = voucherH.get();
        }
        return voucherh;
    }
    @GetMapping("/voucherh")
    public List<VoucherH> getAll(){
        return voucherRepository.findAll();
    }
    @DeleteMapping("/voucherh/{id}")
    public void delete(@PathVariable(name = "id") long id){
        voucherRepository.deleteById(id);
    }

}

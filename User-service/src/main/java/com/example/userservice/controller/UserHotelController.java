package com.example.userservice.controller;

import com.example.userservice.model.HotelReservation;
import com.example.userservice.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/reservations")
public class UserHotelController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public HotelReservation createReservation(@RequestBody HotelReservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @GetMapping("/{userId}")
    public List<HotelReservation> getReservations(@PathVariable Long userId) {
        return reservationService.getReservationsByUserId(userId);
    }
}

package com.example.Hotel_service.controller;


import com.example.Hotel_service.model.Reservation;
import com.example.Hotel_service.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private ReservationService reservationService;

    // Réserver une chambre
    @PostMapping("/reservations")
    public Reservation reserveHotel(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    // Consulter ses propres réservations
    @GetMapping("/reservations/{userId}")
    public List<Reservation> getUserReservations(@PathVariable Long userId) {
        return reservationService.getReservationsByUser(userId);
    }
}
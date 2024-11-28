package com.example.userservice.service;

import com.example.userservice.model.HotelReservation;
import com.example.userservice.repository.HotelReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private HotelReservationRepository reservationRepository;

    public HotelReservation createReservation(HotelReservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<HotelReservation> getReservationsByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }
}

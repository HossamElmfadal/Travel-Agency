package com.example.Hotel_service.repository;

import com.example.Hotel_service.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserEmail(String email);
    List<Reservation> findByUserId(Long userId);
}

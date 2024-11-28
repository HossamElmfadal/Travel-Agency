package com.example.userservice.repository;


import com.example.userservice.model.HotelReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelReservationRepository extends JpaRepository<HotelReservation, Long> {
    List<HotelReservation> findByUserId(Long userId);
}

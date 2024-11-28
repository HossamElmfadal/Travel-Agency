package com.example.carservice.repository;

import com.example.carservice.model.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental, Long> {
    List<CarRental> findByLocationAndAvailable(String location, boolean available);
}

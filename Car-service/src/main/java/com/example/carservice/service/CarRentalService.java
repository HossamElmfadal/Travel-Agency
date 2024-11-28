package com.example.carservice.service;

import com.example.carservice.model.CarRental;
import com.example.carservice.repository.CarRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRentalService {

    @Autowired
    private CarRentalRepository carRentalRepository;

    public List<CarRental> searchAvailableCars(String location) {
        return carRentalRepository.findByLocationAndAvailable(location, true);
    }

    public CarRental saveCarRental(CarRental carRental) {
        return carRentalRepository.save(carRental);
    }
}

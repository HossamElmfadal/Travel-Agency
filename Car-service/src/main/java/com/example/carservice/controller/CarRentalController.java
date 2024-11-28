package com.example.carservice.controller;

import com.example.carservice.model.CarRental;
import com.example.carservice.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car-rentals")
public class CarRentalController {

    @Autowired
    private CarRentalService carRentalService;

    @GetMapping("/search")
    public List<CarRental> searchAvailableCars(@RequestParam String location) {
        return carRentalService.searchAvailableCars(location);
    }

    @PostMapping
    public CarRental addCarRental(@RequestBody CarRental carRental) {
        return carRentalService.saveCarRental(carRental);
    }
}

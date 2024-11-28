package com.example.Flight_service.controller;

import com.example.Flight_service.model.Flight;
import com.example.Flight_service.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam String departure, @RequestParam String arrival) {
        return flightService.searchFlights(departure, arrival);
    }

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }
}

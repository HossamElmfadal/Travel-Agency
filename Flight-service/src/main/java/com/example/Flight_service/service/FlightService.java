package com.example.Flight_service.service;

import com.example.Flight_service.model.Flight;
import com.example.Flight_service.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> searchFlights(String departure, String arrival) {
        return flightRepository.findByDepartureAirportAndArrivalAirport(departure, arrival);
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }
}

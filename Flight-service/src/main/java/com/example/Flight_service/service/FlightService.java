package com.example.Flight_service.service;

import com.example.Flight_service.dto.FlightDTO;
import com.example.Flight_service.model.Flight;
import com.example.Flight_service.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;


    // Créer un nouveau vol
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Lire un vol par son ID
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    // Mettre à jour un vol existant
    public Flight updateFlight(Long id, Flight updatedFlight) {
        Flight existingFlight = getFlightById(id);
        existingFlight.setFlightNumber(updatedFlight.getFlightNumber());
        existingFlight.setAirline(updatedFlight.getAirline());
        existingFlight.setDepartureAirport(updatedFlight.getDepartureAirport());
        existingFlight.setArrivalAirport(updatedFlight.getArrivalAirport());
        existingFlight.setDepartureTime(updatedFlight.getDepartureTime());
        existingFlight.setArrivalTime(updatedFlight.getArrivalTime());
        existingFlight.setPrice(updatedFlight.getPrice());
        return flightRepository.save(existingFlight);
    }

    // Supprimer un vol par son ID
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    // Lire tous les vols
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Recherche des vols par nombre de vol
    public List<FlightDTO> searchFlights(String flightNumber) {
        List<Flight> flights;
        if (flightNumber != null && !flightNumber.isEmpty()) {
            flights = flightRepository.findByFlightNumber(flightNumber);
        } else {
            flights = flightRepository.findAll(); // Retourne tous les vols si aucun critère
        }
        return flights.stream().map(this::mapToDTO).collect(Collectors.toList());
    }


    // Méthode de conversion vol en volDTO
    public FlightDTO mapToDTO(Flight flight) {
        FlightDTO dto = new FlightDTO();
        dto.setId(flight.getId());
        dto.setFlightNumber(flight.getFlightNumber());
        dto.setAirline(flight.getAirline());
        dto.setDepartureAirport(flight.getDepartureAirport());
        dto.setArrivalAirport(flight.getArrivalAirport());
        dto.setDepartureTime(flight.getDepartureTime());
        dto.setArrivalTime(flight.getArrivalTime());
        dto.setPrice(flight.getPrice());
        return dto;
    }
}

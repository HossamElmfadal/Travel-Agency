package com.example.Flight_service.controller;


import com.example.Flight_service.model.Flight;
import com.example.Flight_service.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private FlightService flightService;

    // Créer un nouveau vol
    @PostMapping(path = "/add-flight")
    public ResponseEntity<Flight> createFlight(@Valid @RequestBody Flight flight) {
        Flight createdFlight = flightService.createFlight(flight);
        return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
    }

    // Lire un vol par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        Flight flight = flightService.getFlightById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    // Lire tous les vols
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    // Mettre à jour un vol
    @PutMapping(path = "/edit-flight/{id}")
    public ResponseEntity<Flight> updateFlight(
            @PathVariable Long id,
            @RequestBody Flight updatedFlight) {
        Flight flight = flightService.updateFlight(id, updatedFlight);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    // Supprimer un vol
    @DeleteMapping(path = "delete-flight/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*
    @GetMapping("/search")
    public List<HotelDto> searchHotels(@RequestParam String city, String name) {
        return hotelService.searchHotels(city,name);
    }

    @GetMapping("/{hotelId}/rooms")
    public List<RoomDto> getAvailableRooms(@PathVariable Long hotelId) {
        return hotelService.getAvailableRooms(hotelId);
    }
*/
    /*
    @GetMapping("/{hotelId}/reviews")
    public List<ReviewDto> getHotelReviews(@PathVariable Long hotelId) {
        return hotelService.getReviewsForHotel(hotelId);
    } */
}

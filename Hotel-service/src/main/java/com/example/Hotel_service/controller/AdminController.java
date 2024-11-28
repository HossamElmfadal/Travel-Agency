package com.example.Hotel_service.controller;


import com.example.Hotel_service.model.Hotel;
import com.example.Hotel_service.service.HotelService;
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
    private HotelService hotelService;

    // Créer un nouvel hôtel
    @PostMapping(path = "/add-hotel")
    public ResponseEntity<Hotel> createHotel(@Valid @RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.createHotel(hotel);
        return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
    }

    // Lire un hôtel par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        Hotel hotel = hotelService.getHotelById(id);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    // Lire tous les hôtels
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    // Mettre à jour un hôtel
    @PutMapping(path = "/edit-hotel/{id}")
    public ResponseEntity<Hotel> updateHotel(
            @PathVariable Long id,
            @RequestBody Hotel updatedHotel) {
        Hotel hotel = hotelService.updateHotel(id, updatedHotel);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    // Supprimer un hôtel
    @DeleteMapping(path = "delete-hotel/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
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

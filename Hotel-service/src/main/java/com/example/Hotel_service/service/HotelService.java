package com.example.Hotel_service.service;

import com.example.Hotel_service.dto.HotelDto;
import com.example.Hotel_service.model.Hotel;
import com.example.Hotel_service.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;



    // Créer un nouvel hôtel
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // Lire un hôtel par son ID
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
    }

    // Mettre à jour un hôtel existant
    public Hotel updateHotel(Long id, Hotel updatedHotel) {
        Hotel existingHotel = getHotelById(id);
        existingHotel.setName(updatedHotel.getName());
        existingHotel.setCity(updatedHotel.getCity());
        existingHotel.setAddress(updatedHotel.getAddress());
        existingHotel.setPricePerNight(updatedHotel.getPricePerNight());
        existingHotel.setAvailable(updatedHotel.getAvailable());
        return hotelRepository.save(existingHotel);
    }

    // Supprimer un hôtel par son ID
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

    // Lire tous les hôtels
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // Recherche des hôtels par ville
    public List<HotelDto> searchHotels(String city, String name) {
        List<Hotel> hotels;
        if (city != null && !city.isEmpty()) {
            hotels = hotelRepository.findByCity(city);
        } else {
            hotels = hotelRepository.findAll(); // Retourne tous les hôtels si aucun critère
        }
        return hotels.stream().map(this::mapToDTO).collect(Collectors.toList());
    }


    // Méthode de conversion Hotel en HotelDto
    public HotelDto mapToDTO(Hotel hotel) {
        HotelDto dto = new HotelDto();
        dto.setId(hotel.getId());
        dto.setName(hotel.getName());
        dto.setCity(hotel.getCity());
        dto.setAddress(hotel.getAddress());
        dto.setPricePerNight(hotel.getPricePerNight());
        dto.setAvailable(hotel.getAvailable());
        return dto;
    }

/*
    // Exemple de méthode pour récupérer les avis sur un hôtel via un service externe (RestClient)
    public List<ReviewDto> getReviewsForHotel(Long hotelId) {
        String reviewServiceUrl = "http://REVIEW-SERVICE/api/reviews/hotel/" + hotelId;
        ResponseEntity<List<ReviewDto>> response = restTemplate.exchange(
                reviewServiceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReviewDto>>() {}
        );
        return response.getBody();
    } */
}





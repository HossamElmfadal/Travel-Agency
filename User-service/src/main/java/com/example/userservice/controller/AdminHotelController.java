package com.example.userservice.controller;

import com.example.userservice.dto.HotelDto;
import com.example.userservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/hotels")
public class AdminHotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<HotelDto> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping
    public HotelDto addHotel(@RequestBody HotelDto hotelDTO) {
        return hotelService.addHotel(hotelDTO);
    }

    @PutMapping("/{id}")
    public HotelDto updateHotel(@PathVariable Long id, @RequestBody HotelDto hotelDTO) {
        return hotelService.updateHotel(id, hotelDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }
}

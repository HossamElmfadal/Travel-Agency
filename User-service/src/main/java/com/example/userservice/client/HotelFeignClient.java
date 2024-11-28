package com.example.userservice.client;

import com.example.userservice.dto.HotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name = "HOTEL-SERVICE", url = "${http://localhost:8081/actuator/info}")
@FeignClient("HOTEL-SERVICE")
public interface HotelFeignClient {

    @GetMapping("/hotels")
    List<HotelDto> getAllHotels();

    @PostMapping("/hotels")
    HotelDto addHotel(@RequestBody HotelDto hotelDTO);

    @PutMapping("/hotels/{id}")
    HotelDto updateHotel(@PathVariable Long id, @RequestBody HotelDto hotelDTO);

    @DeleteMapping("/hotels/{id}")
    void deleteHotel(@PathVariable Long id);
}

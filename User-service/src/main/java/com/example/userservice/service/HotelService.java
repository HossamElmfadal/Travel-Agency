package com.example.userservice.service;

import com.example.userservice.client.HotelFeignClient;
import com.example.userservice.dto.HotelDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelFeignClient hotelFeignClient;

    public HotelService(HotelFeignClient hotelFeignClient) {
        this.hotelFeignClient = hotelFeignClient;
    }

    public List<HotelDto> getAllHotels() {
        return hotelFeignClient.getAllHotels();
    }

    public HotelDto addHotel(HotelDto hotelDTO) {
        return hotelFeignClient.addHotel(hotelDTO);
    }

    public HotelDto updateHotel(Long id, HotelDto hotelDTO) {
        return hotelFeignClient.updateHotel(id, hotelDTO);
    }

    public void deleteHotel(Long id) {
        hotelFeignClient.deleteHotel(id);
    }
}

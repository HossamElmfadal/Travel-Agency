package com.example.Hotel_service.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class HotelDTO {
    private Long id;
    private String name;
    private String city;
    private String address;
    private double pricePerNight;
    private Boolean available;

}

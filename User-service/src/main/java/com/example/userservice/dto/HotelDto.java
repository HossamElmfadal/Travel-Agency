package com.example.userservice.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class HotelDto {
    private Long id;
    private String name;
    private String city;
    private String address;
    private double pricePerNight;
    private Boolean available;

}

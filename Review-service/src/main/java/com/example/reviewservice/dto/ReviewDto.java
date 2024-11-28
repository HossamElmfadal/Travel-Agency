package com.example.reviewservice.dto;

import jakarta.persistence.*;
import lombok.*;

import javax.print.attribute.standard.Destination;
import java.time.LocalDateTime;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class ReviewDto {
    private Long id;
    private String comment;
    private int rating;
    private LocalDateTime reviewDate;
    //private Hotel hotel;
    private Destination destination;

}

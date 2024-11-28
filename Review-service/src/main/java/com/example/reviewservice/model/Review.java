package com.example.reviewservice.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.print.attribute.standard.Destination;
import java.time.LocalDateTime;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private int rating;
    private LocalDateTime reviewDate;

    //private Hotel hotel;
    private Destination destination;
}

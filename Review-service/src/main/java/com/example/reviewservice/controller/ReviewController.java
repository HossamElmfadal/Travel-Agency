package com.example.reviewservice.controller;

import com.example.reviewservice.model.Review;
import com.example.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/hotel/{hotelId}")
    public List<Review> getHotelReviews(@PathVariable Long hotelId) {
        return reviewService.getReviewsForHotel(hotelId);
    }

    @GetMapping("/destination/{destinationId}")
    public List<Review> getDestinationReviews(@PathVariable Long destinationId) {
        return reviewService.getReviewsForDestination(destinationId);
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }
}

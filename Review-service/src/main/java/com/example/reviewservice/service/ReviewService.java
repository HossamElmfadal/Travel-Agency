package com.example.reviewservice.service;

import com.example.reviewservice.model.Review;
import com.example.reviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviewsForHotel(Long hotelId) {
        return reviewRepository.findByHotelId(hotelId);
    }

    public List<Review> getReviewsForDestination(Long destinationId) {
        return reviewRepository.findByDestinationId(destinationId);
    }

    public Review saveReview(Review review) {
        review.setReviewDate(LocalDateTime.now());
        return reviewRepository.save(review);
    }
}

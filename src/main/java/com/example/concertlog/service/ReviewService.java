package com.example.concertlog.service;

import com.example.concertlog.entity.Concert;
import com.example.concertlog.entity.Review;
import com.example.concertlog.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getByConcertId(Long concertId) {
        return reviewRepository.findByConcertId(concertId);
    }

    public void save(Review review, Concert concert) {
        review.setConcert(concert);
        review.setDatum(LocalDate.now());
        reviewRepository.save(review);
    }

    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }
}

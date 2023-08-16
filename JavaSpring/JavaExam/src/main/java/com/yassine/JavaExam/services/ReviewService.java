package com.yassine.JavaExam.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.yassine.JavaExam.models.Review;
import com.yassine.JavaExam.models.Show;
import com.yassine.JavaExam.repositories.ReviewRepository;


@Service
public class ReviewService {
	
	private ReviewRepository reviewRepository;

	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	public Review create(Review review) {
		return reviewRepository.save(review);
	}

	 public List<Review> findAllUsersAndRatingsAscending() {
	        return reviewRepository.findAllUsersAndRatingsAscending();
	    }
}
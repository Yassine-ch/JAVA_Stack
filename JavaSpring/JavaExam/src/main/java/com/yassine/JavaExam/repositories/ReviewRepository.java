package com.yassine.JavaExam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yassine.JavaExam.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{
	   @Query("SELECT r.user, r.rating FROM Review r ORDER BY r.rating ASC")
	    List<Review> findAllUsersAndRatingsAscending();
}
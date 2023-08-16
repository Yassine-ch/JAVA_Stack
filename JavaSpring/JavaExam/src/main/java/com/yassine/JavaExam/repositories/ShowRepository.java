package com.yassine.JavaExam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yassine.JavaExam.models.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long>{
	@Query(value="SELECT * FROM shows ORDER BY avg_rating DESC;", nativeQuery=true)
	List<Show> findAll();
	  @Query("SELECT r.user, r.rating FROM Review r ORDER BY r.rating ASC")
	    List<Show> findAllUsersAndRatingsAscending();
}

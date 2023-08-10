package com.yassine.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yassine.lookify.models.Lookify;

public interface LookifyRepository extends CrudRepository<Lookify, Long>  {
	List<Lookify> findAll();
	
	List<Lookify> findByArtistContaining(String search);
	
	List<Lookify>findTop10ByOrderByRatingDesc();

}

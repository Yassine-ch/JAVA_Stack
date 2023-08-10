package com.yassine.DojoAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yassine.DojoAndNinjas.models.Dojo;
import com.yassine.DojoAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	
	@Autowired
	private DojoRepository dojoRepository;
	
	// ----- FIND ALL -----
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}

	// ----- FIND ONE -----
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		return null;
	}
	
	
	// ----- CREATE -----
	public Dojo createDojo(Dojo newDojo) {
		return dojoRepository.save(newDojo);
	}

}
package com.yassine.DojoAndNinjas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yassine.DojoAndNinjas.models.Ninja;
import com.yassine.DojoAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepository;

	
	// ----- CREATE -----
	public Ninja createNinja(Ninja newNinja) {
		return ninjaRepository.save(newNinja);
	}
}
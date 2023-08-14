package com.yassine.beltDemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yassine.beltDemo.models.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
	//Find ALl
	List<Car> findAll();

}

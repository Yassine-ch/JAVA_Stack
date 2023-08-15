package com.yassine.beltDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yassine.beltDemo.models.Car;
import com.yassine.beltDemo.repositories.CarRepository;



@Service
public class CarService {
	@Autowired
	private CarRepository carRepository;
	
	public List<Car> allCars(){
		return carRepository.findAll();
	}
	
	public Car createCar(Car car) {
		return carRepository.save(car);
	}
	
	public Car findCar(Long id) {
		Optional <Car> optionalCar = carRepository.findById(id);
		if(optionalCar.isPresent()) {
			return optionalCar.get();
		}else {
			return null;
		}
	}
	
	public Car updateCar(Car car) {
		return carRepository.save(car);
	}
	
	public void deleteCar(Long id) {
		carRepository.deleteById(id);
	}
	
	
}

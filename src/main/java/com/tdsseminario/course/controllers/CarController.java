package com.tdsseminario.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tdsseminario.course.entities.Car;
import com.tdsseminario.course.repositories.CarRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CarController {
	
	@Autowired
	CarRepository repository;
	
	@GetMapping("/car")
	public List<Car> getAllCar(){
		return repository.findAll();
	}
	
	@GetMapping("/car/{id}")
	public Car getById(@PathVariable Integer id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/car")
	public Car insertCar(@RequestBody Car car) {
		return repository.save(car);
	}
	
	@DeleteMapping("/car/{id}")
	public void deleteCar(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/car/{id}")
	public Car updateCar(@PathVariable Integer id, @RequestBody Car obj) {
		Car newObj = getById(id);
		newObj.setBrand(obj.getBrand());
		newObj.setModel(obj.getModel());
		newObj.setAno(obj.getAno());
		return repository.save(newObj);
	}
}

package com.tdsseminario.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdsseminario.course.entities.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

}

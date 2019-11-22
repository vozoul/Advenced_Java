package com.advenced_java.api.dao;

import com.advenced_java.api.model.Car;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
    
}
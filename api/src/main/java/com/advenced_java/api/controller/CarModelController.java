package com.advenced_java.api.controller;

import java.util.*;

import com.advenced_java.api.dao.CarRepository;
import com.advenced_java.api.model.Car;
import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarModelController {

    @Autowired
    private CarRepository carRepo;

    @GetMapping(value = "/car")
    public List<Car> carList() {
        List<Car> myList = Lists.newArrayList(carRepo.findAll());
        return myList;
    }

    @GetMapping(value = "/car/{id}")
    public Optional<Car> findById(@PathVariable int id) {
        return carRepo.findById(id);
    }

    @PostMapping(value = "/car")
    public Car addCar(@RequestBody Car car) {
        return carRepo.save(car);
    }

    @DeleteMapping(value = "/car/{id}")
    public void remove(@PathVariable int id) {
        carRepo.deleteById(id);
    }

    @PutMapping(value = "/car/{id}")
    public Car update(@PathVariable int id, @RequestBody Car car) {
        car.setId(id);
        carRepo.save(car);
        return car;
    }

}
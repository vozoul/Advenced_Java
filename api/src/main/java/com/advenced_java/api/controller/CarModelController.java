package com.advenced_java.api.controller;

import java.util.List;

import com.advenced_java.api.dao.CarDao;
import com.advenced_java.api.model.Car;

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
    private CarDao CarDao;

    @GetMapping(value = "/car")
    public List<Car> list() {
        return new CarDao().findAll();
    }

    @GetMapping(value = "/car/{Id}")
    public Car findById(@PathVariable int Id) {
        return new CarDao().findById(Id);
    }

    @PostMapping(value = "/car")
    public void addCar(@RequestBody Car car) {
        CarDao.save(car);
    }

    @DeleteMapping(value = "/car/{Id}")
    public void remove(@PathVariable int Id) {
        CarDao.delete(Id);
    }

    @PutMapping(value = "/car/{id}")
    public Car update(@PathVariable int id, @RequestBody Car Car) {
        CarDao.update(id, Car);
        return Car;
    }

}
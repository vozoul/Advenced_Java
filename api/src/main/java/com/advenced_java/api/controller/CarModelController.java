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

    @GetMapping(value = "/car/{id}")
    public Car findById(@PathVariable int id) {
        return new CarDao().findById(id);
    }

    @PostMapping(value = "/car")
    public Car addCar(@RequestBody Car car) {
        return CarDao.save(car);
        
    }

    @DeleteMapping(value = "/car/{id}")
    public void remove(@PathVariable int id) {
        CarDao.delete(id);
    }

    @PutMapping(value = "/car/{id}")
    public Car update(@PathVariable int id, @RequestBody Car car) {
        CarDao.update(id, car);
        return car;
    }

}
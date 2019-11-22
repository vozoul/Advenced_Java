package com.advenced_java.api.dao;

import java.util.List;

import com.advenced_java.api.model.Car;

public interface DAO {

    public List<Car> findAll();

    public Car findById (int Id);

    public Car create (Car Car);

    public Car delete (int Id);

    public Car update (int Id, Car Car);

}
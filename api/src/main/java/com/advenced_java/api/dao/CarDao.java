package com.advenced_java.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.advenced_java.api.model.Car;
import com.advenced_java.api.model.Indexes;

import org.springframework.stereotype.Repository;

@Repository
public class CarDao implements DAO{

    public static List<Car> Cars = new ArrayList<>();

    static {
        Cars.add(new Car(Indexes.getId(), "Ferrari", "308 GTO"));
        Cars.add(new Car(Indexes.getId(), "Renault", "Twingo"));
        Cars.add(new Car(Indexes.getId(), "Peugeot", "307"));
    }

    @Override
    public List<Car> findAll() {
        return Cars;
    }

    @Override
    public Car findById(int Id) {
        for (Car Car: Cars){
            if (Car.getId() == Id){
                return Car;
            }
        }
        return null;
    }

    @Override
    public Car save (Car Car) {
        Car.setId(Indexes.getId());
        Cars.add(Car);
        return Car;
    }

    @Override
    public Car delete(int Id) {
        for (Car Car : Cars) {
            if (Car.getId() == Id) {
                Cars.remove(Car);
                return Car;
            }
        }
        return null;
    }

    @Override
    public Car update(int id, Car updateCar) {
        for (Car car : Cars) {
            if (car.getId() == id) {
                if (updateCar.getModel() != null) {
                    car.setModel(updateCar.getModel());
                }
                if (updateCar.getBrand() != null) {
                    car.setBrand(updateCar.getBrand());
                }
                return car;
            }
        }
        return null;
    }

}
package com.advenced_java.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.advenced_java.api.model.Car;

import org.springframework.stereotype.Repository;

@Repository
public class CarDao implements DAO{

    public static List<Car> Cars = new ArrayList<>();

    static {
        Cars.add(new Car(0, "Ferrari", "308 GTO"));
        Cars.add(new Car(1, "Renault", "Twingo"));
        Cars.add(new Car(2, "Peugeot", "307"));
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
    public Car update(int Id, Car updateCar) {
        for (Car Car : Cars) {
            if (Car.getId() == Id) {
                if (updateCar.getModel() != null) {
                    Car.setModel(updateCar.getModel());
                }
                if (updateCar.getBrand() != null) {
                    Car.setBrand(updateCar.getBrand());
                }
                return Car;
            }
        }
        return null;
    }

}
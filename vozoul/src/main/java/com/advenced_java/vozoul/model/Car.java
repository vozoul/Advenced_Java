package com.advenced_java.vozoul.model;

public class Car {

    private String Brand;
    private String Model;

    public Car() {

    }

    /**
     * Define Car's Brand and Model
     * @param Brand
     * @param Model
     */
    public Car(String Brand, String Model) {
        this.Brand = Brand;
        this.Model = Model;
    }

    /**
     * get Car Brand
     * @return String Brand
     */
    public String getBrand() {
        return Brand;
    }

    /**
     * 
     * @param Brand
     */
    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    /**
     * Get Car model
     * @return String Model
     */
    public String getModel() {
        return Model;
    }

    /**
     * Set car model
     * @param Model
     */
    public void setModel(String Model) {
        this.Model = Model;
    }

}
package com.advenced_java.vozoul.model;

public class Car {

    private Integer id;
    private String brand;
    private String model;

    public Car() {

    }

    /**
     * Define Car's Brand and Model
     * @param brand
     * @param model
     */
    public Car(Integer id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    /**
     * get Car Id
     * 
     * @return Integer id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get Car Brand
     * 
     * @return String Brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Get Car model
     * @return String Model
     */
    public String getModel() {
        return model;
    }

    /**
     * Set car model
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

}
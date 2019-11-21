package com.advenced_java.client.form;

/**
 * Define or get Car brand and Model
 */
public class CarForm {

    private Integer id;
    private String brand;
    private String model;

    /**
     * get Brand of car
     * 
     * @return String brand
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param String Brand
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get Brand of car
     * 
     * @return String brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param String Brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * get car model
     * 
     * @return String Model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param String model
     */
    public void setModel(String model) {
        this.model = model;
    }

}
package com.advenced_java.vozoul.form;

/**
 * Define or get Car brand and Model
 */
public class CarForm {

    private String Brand;
    private String Model;

    /**
     * get Brand of car
     * @return String brand
     */
    public String getBrand() {
        return Brand;
    }

    /**
     * @param String Brand
     */
    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    /**
     * get car model
     * @return String Model
     */
    public String getModel() {
        return Model;
    }

    /**
     * @param String Model
     */
    public void setModel(String Model) {
        this.Model = Model;
    }

}
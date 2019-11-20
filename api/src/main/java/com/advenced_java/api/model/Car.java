package com.advenced_java.api.model;

public class Car {

    private Integer Id;
    private String Brand;
    private String Model;

    public Car() {

    }

    /**
     * Define Car's Brand and Model
     * 
     * @param Id
     * @param Brand
     * @param Model
     */
    public Car(Integer Id, String Brand, String Model) {
        this.Id = Id;
        this.Brand = Brand;
        this.Model = Model;
    }

    /**
     * get Car Brand
     * 
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
     * 
     * @return String Model
     */
    public String getModel() {
        return Model;
    }

    /**
     * Set car model
     * 
     * @param Model
     */
    public void setModel(String Model) {
        this.Model = Model;
    }

    /**
     * Get Car Id
     * 
     * @return String Id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * Set car Id
     * 
     * @param Id
     */
    public void setId(Integer Id) {
        this.Id = Id;
    }

    @Override
    public String toString(){
        return "Car{"+
        "Id=" + Id +
        "Brand=" + Brand +
        "Model=" + Model +
        "}";
    }

}
package com.advenced_java.client.controller;

import java.util.*;

import com.advenced_java.client.form.CarForm;
import com.advenced_java.client.model.Car;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    private String apiUrl = "http://localhost:9090/";

    @GetMapping(value = { "/", "/index" })
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @GetMapping(value = "/CarList")
    public String CarList(Model model) {
        RestTemplate rt = new RestTemplate();
        String url = apiUrl + "car";
        List<Car> cars = rt.getForObject(url, List.class);
        model.addAttribute("cars", cars);
        return "CarList";
    }

    @GetMapping(value = "/Car/{id}")
    public String Car(@PathVariable Integer id, Model model) {
        CarForm carForm = new CarForm();
        RestTemplate rt = new RestTemplate();
        String url = apiUrl + "car/" + id;
        Car car = rt.getForObject(url, Car.class);
        carForm.setBrand(car.getBrand());
        carForm.setModel(car.getModel());
        model.addAttribute("id", id);
        model.addAttribute("carForm", carForm);
        return "Car";
    }

    @GetMapping(value = "/addCar")
    public String showAddCarPage(Model model) {
        CarForm CarForm = new CarForm();
        model.addAttribute("carForm", CarForm);
        return "addCar";
    }

    @PostMapping(value = "/addCar")
    public String saveCar(Model model, @ModelAttribute("carForm") CarForm carForm) {

        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        if (carForm != null) {
            Car newCar = new Car();
            headers.setContentType(MediaType.APPLICATION_JSON);
            newCar.setBrand(carForm.getBrand());
            newCar.setModel(carForm.getModel());
            HttpEntity<Car> request = new HttpEntity<Car>(newCar, headers);
            String url = apiUrl + "car";
            newCar = rt.postForObject(url, request, Car.class);
            model.addAttribute("car", newCar);
            return "redirect:/CarList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCar";
    }

    @PostMapping(value = "/Car/{id}")
    public String updateCar(@PathVariable Integer id, Model model, @ModelAttribute("carForm") CarForm carForm) {

        Car modCar = new Car();
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        modCar.setId(id);
        modCar.setBrand(carForm.getBrand());
        modCar.setModel(carForm.getModel());

        HttpEntity<Car> request = new HttpEntity<Car>(modCar, headers);
        String url = apiUrl + "car/" + id;
        rt.exchange(url, HttpMethod.PUT, request, Car.class);
        model.addAttribute("car", modCar);
        return "redirect:/CarList";
    }
    
    @DeleteMapping(value = "/car/{id}")
    public String remove(@PathVariable Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "car/" + id;
        restTemplate.delete(url);
        return "/CarList";
    }

}
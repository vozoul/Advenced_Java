package com.advenced_java.vozoul.controller;

import java.util.ArrayList;
import java.util.List;

import com.advenced_java.vozoul.form.CarForm;
import com.advenced_java.vozoul.model.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    private static List<Car> Cars = new ArrayList<Car>();

    static {
        Cars.add(new Car("Renault", "Clio"));
        Cars.add(new Car("Peugeot", "307"));
    }

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    /**
     * @param model
     * @return
     */
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    /**
     * @param model
     * @return index page
     */
    @RequestMapping(value = { "/CarList" }, method = RequestMethod.GET)
    public String CarList(Model model) {

        model.addAttribute("Cars", Cars);

        return "CarList";
    }

    /**
     * @param model
     * @return addCar page
     */
    @RequestMapping(value = { "/addCar" }, method = RequestMethod.GET)
    public String showAddCarPage(Model model) {

        CarForm CarForm = new CarForm();
        model.addAttribute("CarForm", CarForm);

        return "addCar";
    }

    /**
     * @param model
     * @param CarForm
     * @return addCar.html with added car
     * @throws errorMessage
     */
    @RequestMapping(value = { "/addCar" }, method = RequestMethod.POST)
    public String saveCar(Model model, //
            @ModelAttribute("CarForm") CarForm CarForm) {

        String Brand = CarForm.getBrand();
        String Model = CarForm.getModel();

        if (Brand != null && Brand.length() > 0 //
                && Model != null && Model.length() > 0) {
            Car newCar = new Car(Brand, Model);
            Cars.add(newCar);

            return "redirect:/CarList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCar";
    }

}
package com.advenced_java.vozoul.controller;

// import java.io.UnsupportedEncodingException;
// import java.net.URI;
// import java.net.URLEncoder;
// import java.nio.charset.StandardCharsets;
// import java.util.ArrayList;
import java.util.List;

import com.advenced_java.vozoul.form.CarForm;
// import com.advenced_java.vozoul.form.CarForm;
import com.advenced_java.vozoul.model.Car;
import org.springframework.beans.factory.annotation.Value;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
// import org.springframework.web.util.UriComponentsBuilder;

// import net.minidev.json.JSONArray;

@Controller
public class MainController {
    // private static List<Car> Cars = new ArrayList<Car>();

    // static {
    //     Cars.add(new Car("Renault", "Clio"));
    //     Cars.add(new Car("Peugeot", "307"));
    // }

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    /**
     * @param model
     * @return
     */
    @GetMapping(value = { "/", "/index"})
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    /**
     * @param model
     * @return index page
     */
    @GetMapping(value = "/CarList")
    public String CarList(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:9090/car";

        List<Car> cars = restTemplate.getForObject(url, List.class);

        model.addAttribute("cars", cars);

        return "CarList";
    }

    /**
     * @param model
     * @return index page
     */
    @GetMapping(value = "/Car/{id}")
    public String Car(@PathVariable Integer id, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/car/" + id ;

        Car car = restTemplate.getForObject(url, Car.class);

        model.addAttribute("car", car);

        return "Car";
    }

    // /**
    //  * @param model
    //  * @return addCar page
    //  */
    // @RequestMapping(value = { "/addCar" }, method = RequestMethod.GET)
    // public String showAddCarPage(Model model) {

    //     CarForm CarForm = new CarForm();
    //     model.addAttribute("CarForm", CarForm);

    //     return "addCar";
    // }

    // /**
    //  * @param model
    //  * @param CarForm
    //  * @return addCar.html with added car
    //  * @throws errorMessage
    //  */
    // @RequestMapping(value = { "/addCar" }, method = RequestMethod.POST)
    // public String saveCar(Model model, //
    //         @ModelAttribute("CarForm") CarForm CarForm) {

    //     Integer id = CarForm.getId();
    //     String brand = CarForm.getBrand();
    //     String model = CarForm.getModel();

    //     if (Brand != null && Brand.length() > 0 //
    //             && Model != null && Model.length() > 0) {
    //         Car newCar = new Car(id, brand, model);
    //         cars.add(newCar);

    //         return "redirect:/CarList";
    //     }

    //     model.addAttribute("errorMessage", errorMessage);
    //     return "addCar";
    // }

}
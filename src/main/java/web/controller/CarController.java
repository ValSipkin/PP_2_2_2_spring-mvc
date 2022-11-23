package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;
import java.util.Optional;

@Controller
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("/cars")
    public String showCars(@RequestParam(value = "count", required = false) Optional<Integer> carsNumber, ModelMap model) {
        List<Car> carList = carService.getCars(carsNumber.orElse(5));
        model.addAttribute("cars", carList);
        return "cars";
    }

}

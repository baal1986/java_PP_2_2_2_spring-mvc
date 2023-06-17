package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam("count") String count, ModelMap model) {
        try {
            model.addAttribute("cars",
                    new CarServiceImp().getCar(new ArrayList<>(Arrays.asList(
                            new Car("BMW", 6, Car.Color.Black),
                            new Car("BMW", 5, Car.Color.Blue),
                            new Car("BMW", 3, Car.Color.Red),
                            new Car("Mercedes-Benz", 600, Car.Color.Red),
                            new Car("Mercedes-Benz", 500, Car.Color.Black)
                    )), Integer.parseInt(count)));
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            e.printStackTrace();
        }

        return "cars";
    }

}
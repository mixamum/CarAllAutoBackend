package com.mixamum.carallauto.controller;

import com.mixamum.carallauto.entity.Car;
import com.mixamum.carallauto.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public List<Car> findAll() {
        return carService.findAll();
    }


    @PostMapping("/cars")
    public Car save(@RequestBody Car theCar) {
        theCar.setId(0);

        Car dbCar = carService.save(theCar);

        return dbCar;
    }


}

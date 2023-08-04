package com.mixamum.carallauto.controller;

import com.mixamum.carallauto.entity.Car;
import com.mixamum.carallauto.service.CarService;
import com.mixamum.carallauto.util.LogController;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.net.http.HttpClient;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CarController {

    private final LogController logController = new LogController();


    @Autowired
    private CarService carService;

    private final ModelMapper modelMapper = new ModelMapper();


    @GetMapping("/cars")
    public ResponseEntity<List<Car>> findAll() {
        try {
            List<Car> cars = carService.findAll();
            logController.logInfo("Successful get request");
            var carsDTOList = cars.stream()
                    .map(car -> modelMapper.map(car, Car.class))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(carsDTOList, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logController.logError(e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car theCar) {
        var car = modelMapper.map(theCar, Car.class);
        try {
           var createdCar = carService.save(car);
           logController.logInfo("POST car successful");
           var createdCarDTO = modelMapper.map(createdCar, Car.class);
           return new ResponseEntity<>(createdCarDTO, HttpStatus.CREATED);
        } catch (HttpClientErrorException e) {
            logController.logError(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable("id") int id) {
        try {
            carService.deleteById(id);
            logController.logInfo("Successful deletion by ID");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logController.logError(e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

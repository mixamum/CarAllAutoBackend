package com.mixamum.carallauto.service;

import com.mixamum.carallauto.dao.CarRepository;
import com.mixamum.carallauto.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(int theId) {
        Optional<Car> result = carRepository.findById(theId);

        Car theCar = null;

        if (result.isPresent()) {
            theCar = result.get();
        } else {
            throw new RuntimeException("Did not find car id - " + theId);
        }

        return theCar;
    }

    @Transactional
    @Override
    public Car save(Car theCar) {
        return carRepository.save(theCar);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        carRepository.deleteById(theId);
    }
}

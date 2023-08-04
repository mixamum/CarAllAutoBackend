package com.mixamum.carallauto.dao;

import com.mixamum.carallauto.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}

package com.mixamum.carallauto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="make")
    private String make;

    @Column(name="model")
    private String model;

    @Column(name="color")
    private String color;

    @Column(name="year")
    private Integer year;

    @Column(name="mileage")
    private Integer mileage;


    public Car(String make, String model, int year, int mileage, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.color = color;
    }
}

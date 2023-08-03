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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="make")
    private String make;

    @Column(name="model")
    private String model;

    @Column(name="year")
    private int year;

    @Column(name="mileage")
    private int mileage;

    @Column(name="color")
    private String color;

    public Car(String make, String model, int year, int mileage, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.color = color;
    }
}

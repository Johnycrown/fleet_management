package com.johny.fleet.management.vehicle.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String modelNumber;
    private String plateNumber;
    private Date  dateRegister;
    private int capacity;
    private String status;
    private String model;

    private double latitude;
    private double longitude;
    private double speed;
    private double fuelLevel;


}

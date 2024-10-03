package com.johny.fleet.management.vehicle.domain;

import lombok.Data;

@Data
public class LocationData {
    private double latitude;
    private double longitude;
    private double speed;
    private double fuelLevel;
}

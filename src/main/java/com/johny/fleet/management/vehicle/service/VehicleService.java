package com.johny.fleet.management.vehicle.service;

import com.johny.fleet.management.vehicle.domain.Vehicle;

import java.util.List;

public interface VehicleService {

    public List<Vehicle> findAll();

    public Vehicle findById(Long id);

    public Vehicle save(Vehicle vehicle);
    public void deleteById(Long id);
}

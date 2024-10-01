package com.johny.fleet.management.driver.service;

import com.johny.fleet.management.driver.domain.Driver;
import com.johny.fleet.management.vehicle.domain.Vehicle;

import java.util.List;

public interface DriverService {
    public List<Driver> findAll();

    public Driver findById(Long id);

    public Driver save(Driver driver);
    public void deleteById(Long id);
}

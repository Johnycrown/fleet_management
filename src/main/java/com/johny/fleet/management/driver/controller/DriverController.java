package com.johny.fleet.management.driver.controller;

import com.johny.fleet.management.driver.domain.Driver;
import com.johny.fleet.management.driver.service.DriverService;
import com.johny.fleet.management.vehicle.domain.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;


    @GetMapping
    public List<Driver> getAllVehicles() {
        return driverService.findAll();
    }

    @GetMapping("/{id}")
    public Driver getVehicleById(@PathVariable Long id) {
        return driverService.findById(id);
    }

    @PostMapping
    public Driver createVehicle(@RequestBody Driver driver) {
        return driverService.save(driver);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        driverService.deleteById(id);
    }

}

package com.johny.fleet.management.vehicle.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.johny.fleet.management.vehicle.domain.Vehicle;
import com.johny.fleet.management.vehicle.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    ObjectMapper objectMapper = new ObjectMapper();



    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteById(Long id) {
        vehicleRepository.deleteById(id);
    }


    public void updateVehicleData(Long vehicleId, double latitude, double longitude, double speed, double fuelLevel) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle != null) {
            vehicle.setLatitude(latitude);
            vehicle.setLongitude(longitude);
            vehicle.setSpeed(speed);
            vehicle.setFuelLevel(fuelLevel);
            vehicleRepository.save(vehicle);
        }
    }


}

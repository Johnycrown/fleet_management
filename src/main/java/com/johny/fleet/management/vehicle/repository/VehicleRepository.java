package com.johny.fleet.management.vehicle.repository;

import com.johny.fleet.management.vehicle.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}

package com.johny.fleet.management.maintainance.controller;

import com.johny.fleet.management.maintainance.domain.Maintenance;
import com.johny.fleet.management.maintainance.service.MaintenanceService;
import com.johny.fleet.management.vehicle.domain.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
@RequiredArgsConstructor
public class MaintenanceController {
private final MaintenanceService maintenanceService;

    @GetMapping
    public List<Maintenance> getAllVehicles() {
        return maintenanceService.findAll();
    }

    @GetMapping("/{id}")
    public Maintenance getVehicleById(@PathVariable Long id) {
        return maintenanceService.findById(id);
    }

    @PostMapping
    public Maintenance createMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.save(maintenance);
    }

    @PutMapping("/{id}")
    public Maintenance updateMaintenance(@PathVariable Long id, @RequestBody Maintenance vehicle) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteMaintenance(@PathVariable Long id) {
        maintenanceService.deleteById(id);
    }
}

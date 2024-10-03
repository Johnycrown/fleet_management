package com.johny.fleet.management.maintainance.service;

import com.johny.fleet.management.maintainance.domain.Maintenance;
import com.johny.fleet.management.trip.domain.Trip;

import java.util.List;

public interface MaintenanceService {

    public List<Maintenance> findAll();

    public Maintenance findById(Long id);

    public Maintenance save(Maintenance maintenance);
    public void deleteById(Long id);
}

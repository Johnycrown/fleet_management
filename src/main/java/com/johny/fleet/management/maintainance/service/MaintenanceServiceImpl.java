package com.johny.fleet.management.maintainance.service;

import com.johny.fleet.management.maintainance.domain.Maintenance;
import com.johny.fleet.management.maintainance.repository.MaintenanceRepository;
import com.johny.fleet.management.trip.domain.Trip;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService {
    MaintenanceRepository maintenanceRepository;
    @Override
    public List<Maintenance> findAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance findById(Long id) {
        Optional<Maintenance> trip = maintenanceRepository.findById(id);
        return trip.orElse(null);    }

    @Override
    public Maintenance save(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Maintenance> maintenance = maintenanceRepository.findById(id);
        maintenance.ifPresent(maintenanceRepository::delete);

    }
}

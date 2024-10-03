package com.johny.fleet.management.maintainance.repository;

import com.johny.fleet.management.maintainance.domain.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Long> {
}

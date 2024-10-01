package com.johny.fleet.management.driver.repository;

import com.johny.fleet.management.driver.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {

}

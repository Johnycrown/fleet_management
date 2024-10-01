package com.johny.fleet.management.trip.repository;

import com.johny.fleet.management.trip.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}

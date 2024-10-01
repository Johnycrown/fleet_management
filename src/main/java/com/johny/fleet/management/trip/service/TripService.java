package com.johny.fleet.management.trip.service;

import com.johny.fleet.management.driver.domain.Driver;
import com.johny.fleet.management.trip.domain.Trip;

import java.util.List;

public interface TripService {

    public List<Trip> findAll();

    public Trip findById(Long id);

    public Trip save(Trip driver);
    public void deleteById(Long id);
}

package com.johny.fleet.management.trip.service;

import com.johny.fleet.management.driver.domain.Driver;
import com.johny.fleet.management.trip.domain.Trip;
import com.johny.fleet.management.trip.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements  TripService{
    private final TripRepository tripRepository;
    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @Override
    public Trip findById(Long id) {
        Optional<Trip> trip = tripRepository.findById(id);
        return trip.orElse(null);    }

    @Override
    public Trip save(Trip driver) {
        return tripRepository.save(driver);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Trip> trip = tripRepository.findById(id);
        trip.ifPresent(tripRepository::delete);
    }
}

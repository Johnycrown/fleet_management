package com.johny.fleet.management.trip.controller;

import com.johny.fleet.management.trip.domain.Trip;
import com.johny.fleet.management.trip.service.TripService;
import com.johny.fleet.management.vehicle.domain.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
@RequiredArgsConstructor
public class TripController {
    private TripService tripService;

    @GetMapping
    public List<Trip> getAllTrip() {
        return tripService.findAll();
    }

    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return tripService.findById(id);
    }

    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.save(trip);
    }

    @PutMapping("/{id}")
    public Trip updateTrip(@PathVariable Long id, @RequestBody Trip trip) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable Long id) {
        tripService.deleteById(id);
    }
}

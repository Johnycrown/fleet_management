package com.johny.fleet.management.driver.service;

import com.johny.fleet.management.driver.domain.Driver;
import com.johny.fleet.management.driver.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService{
    private final DriverRepository driverRepository;
    @Override
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    @Override
    public Driver findById(Long id) {
        Optional<Driver> driver = driverRepository.findById(id);
        return driver.orElse(null);
    }

    @Override
    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Driver> driver = driverRepository.findById(id);

        driver.ifPresent(driverRepository::delete);


    }
}

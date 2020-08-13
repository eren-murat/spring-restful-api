package com.example.xtrmapi.services;

import com.example.xtrmapi.domain.Location;
import com.example.xtrmapi.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public Location findLocationById(final Long id) {
        return locationRepository.findById(id).get();
    }

    @Override
    public List<Location> findAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location saveLocation(final Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteLocation(final Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public void updateLocation(final Long id, final Location updatedLocation) {
        locationRepository.findById(id).get().updateFields(updatedLocation);
        locationRepository.save(locationRepository.findById(id).get());
    }

    @Override
    public List<Location> searchLocation(String sport) {
        return locationRepository.findBySport(sport);
    }
}

package com.example.xtrmapi.services;

import com.example.xtrmapi.domain.Location;

import java.util.List;

public interface LocationService {

    Location findLocationById(Long id);

    List<Location> findAllLocations();

    Location saveLocation(Location location);

    void deleteLocation(Long id);

    void updateLocation(Long id, Location location);

    List<Location> searchLocation(String sport);
}

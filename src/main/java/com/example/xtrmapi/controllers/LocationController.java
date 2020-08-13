package com.example.xtrmapi.controllers;

import com.example.xtrmapi.domain.Location;
import com.example.xtrmapi.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(LocationController.BASE_URL)
public class LocationController {

    public static final String BASE_URL = "api/v1/locations";
    private final LocationService locationService;

    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.findAllLocations();
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable final Long id) {
        return locationService.findLocationById(id);
    }

    /**
     *  Bonus method for mobile users.
     * @param sports List of extreme sports desired by the user.
     * @param monthStart Start of the vacation month.
     * @param monthFinish End of the vacation month.
     * @param dayStart Start of the vacation day.
     * @param dayFinish End of the vacation day.
     * @return  List of locations that satisfy all the input parameters.
     */
    @GetMapping("/search")
    public List<Location> searchLocation(@RequestParam(required = false, name = "sport") List<String> sports,
                                         @RequestParam(name = "monthStart") String monthStart,
                                         @RequestParam(name = "monthFinish") String monthFinish,
                                         @RequestParam(name = "dayStart") Integer dayStart,
                                         @RequestParam(name = "dayFinish") Integer dayFinish) {
        List<Location> firstFilter = new ArrayList<Location>();
        for (String s : sports) {
            firstFilter.addAll(locationService.searchLocation(s));
        }

        List<Location> filtered = new ArrayList<Location>();
        for (Location loc : firstFilter) {
            if (loc.checkDate(monthStart, monthFinish, dayStart, dayFinish)) {
                filtered.add(loc);
            }
        }
        filtered.sort(Comparator.comparing(Location::getCostPerDay));

        return filtered;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location saveLocation(@RequestBody final Location location) {
        return locationService.saveLocation(location);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable final Long id) {
        locationService.deleteLocation(id);
        return ResponseEntity.ok("Location " + id + " deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLocation(@PathVariable final Long id, @RequestBody final Location location) {
        locationService.updateLocation(id, location);
        return ResponseEntity.ok("Location " + id + " updated");
    }
}

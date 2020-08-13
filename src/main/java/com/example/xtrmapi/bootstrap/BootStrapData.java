package com.example.xtrmapi.bootstrap;

import com.example.xtrmapi.domain.Location;
import com.example.xtrmapi.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BootStrapData implements CommandLineRunner {

    private final LocationRepository locationRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading Location Data");

        // Populate the database for testing purposes
        Location loc1 = new Location();
        loc1.setCountry("Romania");
        loc1.setCity("Brasov");
        loc1.setRegion("Brasov");
        loc1.setSport("Ski");
        loc1.setMonthStart("December");
        loc1.setMonthFinish("February");
        loc1.setDayStart(1);
        loc1.setDayFinish(20);
        loc1.setCostPerDay(15.5);
        locationRepository.save(loc1);

        Location loc2 = new Location();
        loc2.setCountry("Romania");
        loc2.setCity("Constanta");
        loc2.setRegion("Constanta");
        loc2.setSport("Paragliding");
        loc2.setMonthStart("June");
        loc2.setMonthFinish("August");
        loc2.setDayStart(1);
        loc2.setDayFinish(31);
        loc2.setCostPerDay(20.5);
        locationRepository.save(loc2);

        Location loc3 = new Location();
        loc3.setCountry("Romania");
        loc3.setCity("Predeal");
        loc3.setRegion("Brasov");
        loc3.setSport("Ski");
        loc3.setMonthStart("January");
        loc3.setMonthFinish("February");
        loc3.setDayStart(1);
        loc3.setDayFinish(31);
        loc3.setCostPerDay(20.5);
        locationRepository.save(loc3);

        Location loc4 = new Location();
        loc4.setCountry("Romania");
        loc4.setCity("Bucuresti");
        loc4.setRegion("Bucuresti");
        loc4.setSport("Skateboarding");
        loc4.setMonthStart("June");
        loc4.setMonthFinish("September");
        loc4.setDayStart(1);
        loc4.setDayFinish(31);
        loc4.setCostPerDay(10.5);
        locationRepository.save(loc4);

        Location loc5 = new Location();
        loc5.setCountry("Romania");
        loc5.setCity("Valea Prahovei");
        loc5.setRegion("Azuga");
        loc5.setSport("Ski");
        loc5.setMonthStart("December");
        loc5.setMonthFinish("February");
        loc5.setDayStart(10);
        loc5.setDayFinish(10);
        loc5.setCostPerDay(18.5);
        locationRepository.save(loc5);

        System.out.println("Locations Saved: " + locationRepository.count());
    }
}

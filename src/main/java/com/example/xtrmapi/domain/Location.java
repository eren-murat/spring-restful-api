package com.example.xtrmapi.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String region;
    private String city;
    private String sport;
    private String monthStart;
    private String monthFinish;
    private Integer dayStart;
    private Integer dayFinish;
    private Double costPerDay;

    /**
     *  Method used to update the fields of a location.
     * @param other location with the new desired information
     */
    public void updateFields(final Location other) {
        this.setCountry(other.getCountry());
        this.setRegion(other.getRegion());
        this.setCity(other.getCity());
        this.setSport(other.getSport());
        this.setMonthStart(other.getMonthStart());
        this.setMonthFinish(other.getMonthFinish());
        this.setDayStart(other.getDayStart());
        this.setDayFinish(other.getDayFinish());
        this.setCostPerDay(other.getCostPerDay());
    }

    public boolean checkDate(final String monthStart, final String monthFinish, final Integer dayStart,
                             final Integer dayFinish) {
        return this.getMonthStart().equals(monthStart) && this.getMonthFinish().equals(monthFinish)
                && this.getDayStart() >= dayStart && this.getDayFinish() <= dayFinish;
    }
}

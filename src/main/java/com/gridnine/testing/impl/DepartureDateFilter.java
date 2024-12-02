package com.gridnine.testing.impl;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.filter.FlightFilter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureDateFilter implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().get(0).getDepartureDate().isAfter(now))
                .collect(Collectors.toList());
    }
}

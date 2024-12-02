package com.gridnine.testing.impl;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.filter.FlightFilter;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDepartureFilter implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}

package com.gridnine.testing.impl;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.filter.FlightFilter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A filter that checks if the departure date of the first segment of a flight
 * is after the current date and time. This filter implements the {@link FlightFilter} interface.
 */
public class DepartureDateFilter implements FlightFilter {

    /**
     * Filters the provided list of flights, retaining only those flights
     * where the departure date of the first segment is after the current date and time.
     *
     * @param flights a list of flights to be filtered, must not be null
     * @return a list of flights that meet the criteria,
     *         containing only flights with a valid departure date for the first segment
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().get(0).getDepartureDate().isAfter(now))
                .collect(Collectors.toList());
    }
}

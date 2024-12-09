package com.gridnine.testing.impl;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.filter.FlightFilter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A filter that checks if all segments of a flight have arrival dates
 * that occur after their respective departure dates.
 * This filter implements the {@link FlightFilter} interface.
 */
public class ArrivalBeforeDepartureFilter implements FlightFilter {

    /**
     * Filters the provided list of flights, retaining only those flights
     * where all segments have arrival dates after their departure dates.
     *
     * @param flights a list of flights to be filtered, must not be null
     * @return a list of flights that meet the criteria,
     *         containing only flights with valid segment timings
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}

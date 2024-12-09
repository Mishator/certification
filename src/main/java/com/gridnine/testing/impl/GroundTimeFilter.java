package com.gridnine.testing.impl;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;
import com.gridnine.testing.filter.FlightFilter;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A filter that checks if the total ground time between segments of a flight
 * is less than a specified maximum ground time. This filter implements the
 * {@link FlightFilter} interface.
 */
public class GroundTimeFilter implements FlightFilter {

    private static final Duration MAX_GROUND_TIME = Duration.ofHours(2);

    /**
     * Filters the provided list of flights, retaining only those flights
     * where the total ground time between all segments is less than
     * the maximum allowed ground time.
     *
     * @param flights a list of flights to be filtered, must not be null
     * @return a list of flights that meet the criteria,
     *         containing only flights with total ground time less than the maximum
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    Duration totalGroundTime = Duration.ZERO;
                    for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                        Segment currentSegment = flight.getSegments().get(i);
                        Segment nextSegment = flight.getSegments().get(i + 1);
                        totalGroundTime = totalGroundTime.plus(Duration.between(currentSegment.getArrivalDate(),
                                nextSegment.getDepartureDate()));
                    }
                    return totalGroundTime.compareTo(MAX_GROUND_TIME) < 0;
                })
                .collect(Collectors.toList());
    }

}

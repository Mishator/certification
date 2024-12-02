package com.gridnine.testing.impl;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;
import com.gridnine.testing.filter.FlightFilter;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class GroundTimeFilter implements FlightFilter {

    private static final Duration MAX_GROUND_TIME = Duration.ofHours(2);

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

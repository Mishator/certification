package com.gridnine.testing.entity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a flight consisting of multiple segments.
 * A flight is defined by a list of segments, where each segment represents a part of the journey.
 */
public class Flight {
    private final List<Segment> segments;

    /**
     * Constructs a new Flight instance with the specified list of segments.
     *
     * @param segs a list of {@link Segment} objects representing the segments of this flight
     */
    public Flight(final List<Segment> segs) {
        this.segments = segs;
    }

    /**
     * Returns the list of segments that make up this flight.
     *
     * @return a list of {@link Segment} objects associated with this flight
     */
    public List<Segment> getSegments() {
        return segments;
    }

    /**
     * Returns a string representation of the flight, which includes the string representation
     * of each segment concatenated with a space.
     *
     * @return a string representing the flight's segments
     */
    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
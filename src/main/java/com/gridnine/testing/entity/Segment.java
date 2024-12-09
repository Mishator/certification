package com.gridnine.testing.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Represents a segment of a flight with a departure and arrival time.
 * Each segment consists of a departure date and an arrival date, which are both required.
 */
public class Segment {
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;

    /**
     * Constructs a new Segment with the specified departure and arrival dates.
     *
     * @param dep the departure date and time, must not be null
     * @param arr the arrival date and time, must not be null
     * @throws NullPointerException if either {@code dep} or {@code arr} is null
     */
    public Segment(LocalDateTime dep, LocalDateTime arr) {
        departureDate = Objects.requireNonNull(dep);
        arrivalDate = Objects.requireNonNull(arr);
    }

    /**
     * Returns the departure date and time of this segment.
     *
     * @return the departure date and time
     */
    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    /**
     * Returns the arrival date and time of this segment.
     *
     * @return the arrival date and time
     */
    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Returns a string representation of this segment in the format [departure|arrival].
     * The dates are formatted as "yyyy-MM-dd'T'HH:mm".
     *
     * @return a string representation of the segment
     */
    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
                + ']';
    }
}

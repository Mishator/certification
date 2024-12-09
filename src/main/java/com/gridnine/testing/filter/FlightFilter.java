package com.gridnine.testing.filter;

import com.gridnine.testing.entity.Flight;

import java.util.List;

/**
 * Interface for filtering lists of flights based on various criteria.
 * Implementations of this interface provide methods to filter a list of {@link Flight} objects
 * according to specific rules.
 */
public interface FlightFilter {

    /**
     * Filters a list of flights based on the implemented filter's criteria.
     *
     * @param flights The list of {@link Flight} objects to filter. Cannot be null.
     * @return A new list containing only the flights that meet the filter's criteria.
     *         Returns an empty list if no flights meet the criteria or if the input list is empty.
     *         The returned list will never be null.
     * @throws NullPointerException if the input list 'flights' is null.
     */
    List<Flight> filter(List<Flight> flights);

}

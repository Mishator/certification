package com.gridnine.testing;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.FlightBuilder;
import com.gridnine.testing.impl.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.impl.DepartureDateFilter;
import com.gridnine.testing.impl.GroundTimeFilter;

import java.util.List;

/**
 * The main class of the flight filter application.
 * This class demonstrates the usage of different flight filters.
 */
public class Main {

    /**
     * The main method of the application.
     * Creates a list of flights, applies three different filters, and prints the results.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        // Creates a list of flights using the FlightBuilder.
        List<Flight> flights = FlightBuilder.createFlights();

        // Applies the DepartureDateFilter and prints the filtered flights.
        List<Flight> filtered1 = new DepartureDateFilter().filter(flights);
        System.out.println("Flights with departure date after current moment:");
        filtered1.forEach(System.out::println);

        // Applies the ArrivalBeforeDepartureFilter and prints the filtered flights.
        List<Flight> filtered2 = new ArrivalBeforeDepartureFilter().filter(flights);
        System.out.println("\nFlights with segments where arrival date is before departure date:");
        filtered2.forEach(System.out::println);

        // Applies the GroundTimeFilter and prints the filtered flights.
        List<Flight> filtered3 = new GroundTimeFilter().filter(flights);
        System.out.println("\nFlights where total time spent on the ground does not exceed two hours:");
        filtered3.forEach(System.out::println);
    }
}
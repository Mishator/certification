package com.gridnine.testing;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.FlightBuilder;
import com.gridnine.testing.impl.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.impl.DepartureDateFilter;
import com.gridnine.testing.impl.GroundTimeFilter;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();

        List<Flight> filtered1 = new DepartureDateFilter().filter(flights);
        System.out.println("Flights with departure date after current moment:");
        filtered1.forEach(System.out::println);

        List<Flight> filtered2 = new ArrivalBeforeDepartureFilter().filter(flights);
        System.out.println("\nFlights with segments where arrival date is before departure date:");
        filtered2.forEach(System.out::println);

        List<Flight> filtered3 = new GroundTimeFilter().filter(flights);
        System.out.println("\nFlights where total time spent on the ground does not exceed two hours:");
        filtered3.forEach(System.out::println);
    }
}
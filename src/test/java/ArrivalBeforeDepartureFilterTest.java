import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;
import com.gridnine.testing.impl.ArrivalBeforeDepartureFilter;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrivalBeforeDepartureFilterTest {


    @Test
    void testFilterWithValidFlights() {
        // Create an instance of the ArrivalBeforeDepartureFilter
        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();

        // Define a valid flight segment where arrival is after departure
        Segment segment1 = new Segment(LocalDateTime.of(2023, 10, 1, 10, 0), LocalDateTime.of(2023, 10, 1, 12, 0));
        Segment segment2 = new Segment(LocalDateTime.of(2023, 10, 2, 14, 0), LocalDateTime.of(2023, 10, 2, 16, 0));

        // Create a flight consisting of the valid segments
        Flight flight1 = new Flight(Arrays.asList(segment1, segment2));

        // Apply the filter to the list containing the valid flight
        List<Flight> flights = filter.filter(Arrays.asList(flight1));

        // Assert that the filtered list contains one valid flight
        assertEquals(1, flights.size());
    }

    @Test
    void testFilterWithInvalidFlights() {
        // Create an instance of the ArrivalBeforeDepartureFilter
        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();

        // Define an invalid flight segment where arrival is before departure
        Segment segment1 = new Segment(LocalDateTime.of(2023, 10, 1, 10, 0), LocalDateTime.of(2023, 10, 1, 9, 0));

        // Create a flight consisting of the invalid segment
        Flight flight2 = new Flight(Arrays.asList(segment1));

        // Apply the filter to the list containing the invalid flight
        List<Flight> flights = filter.filter(Arrays.asList(flight2));

        // Assert that the filtered list is empty since the flight is invalid
        assertEquals(0, flights.size());
    }

    @Test
    void testFilterWithMixedFlights() {
        // Create an instance of the ArrivalBeforeDepartureFilter
        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();

        // Define valid and invalid flight segments
        Segment segment1 = new Segment(LocalDateTime.of(2023, 10, 1, 10, 0), LocalDateTime.of(2023, 10, 1, 12, 0));
        Segment segment2 = new Segment(LocalDateTime.of(2023, 10, 2, 14, 0), LocalDateTime.of(2023, 10, 2, 16, 0));
        Segment segment3 = new Segment(LocalDateTime.of(2023, 10, 3, 10, 0), LocalDateTime.of(2023, 10, 3, 9, 0));

        // Create flights with a mix of valid and invalid segments
        Flight flight1 = new Flight(Arrays.asList(segment1, segment2));
        Flight flight2 = new Flight(Arrays.asList(segment3));

        // Apply the filter to the list containing both flights
        List<Flight> flights = filter.filter(Arrays.asList(flight1, flight2));

        // Assert that only one valid flight remains after filtering
        assertEquals(1, flights.size());
    }
}

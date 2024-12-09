import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;
import com.gridnine.testing.impl.GroundTimeFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroundTimeFilterTest {

    private GroundTimeFilter groundTimeFilter;

    @BeforeEach
    public void setUp() {
        groundTimeFilter = new GroundTimeFilter();
    }

    @Test
    public void testFlightsWithGroundTimeUnderTwoHours() {
        List<Flight> flights = new ArrayList<>();

        // Creating segments with a time between them of less than 2 hours
        Segment segment1 = new Segment(LocalDateTime.of(2023, 10, 1, 10, 0),
                LocalDateTime.of(2023, 10, 1, 12, 0));
        Segment segment2 = new Segment(LocalDateTime.of(2023, 10, 1, 13, 0),
                LocalDateTime.of(2023, 10, 1, 15, 0));

        Flight flight = new Flight(List.of(segment1, segment2));
        flights.add(flight);

        List<Flight> filteredFlights = groundTimeFilter.filter(flights);

        assertEquals(1, filteredFlights.size());
        assertEquals(flight, filteredFlights.get(0));
    }

    @Test
    public void testFlightsWithGroundTimeOverTwoHours() {
        List<Flight> flights = new ArrayList<>();

        // Creating segments with a time between them of more than 2 hours
        Segment segment1 = new Segment(LocalDateTime.of(2023, 10, 1, 10, 0),
                LocalDateTime.of(2023, 10, 1, 12, 0));
        Segment segment2 = new Segment(LocalDateTime.of(2023, 10, 1, 15, 30),
                LocalDateTime.of(2023, 10, 1, 17, 0));

        Flight flight = new Flight(List.of(segment1, segment2));
        flights.add(flight);

        List<Flight> filteredFlights = groundTimeFilter.filter(flights);

        assertEquals(0, filteredFlights.size());
    }

    @Test
    public void testMultipleFlightsWithMixedGroundTimes() {
        List<Flight> flights = new ArrayList<>();

        // First flight: time on the ground is less than two hours
        Segment segment1 = new Segment(LocalDateTime.of(2023, 10, 1, 10, 0),
                LocalDateTime.of(2023, 10, 1, 12, 0));
        Segment segment2 = new Segment(LocalDateTime.of(2023, 10, 1, 13, 0),
                LocalDateTime.of(2023, 10, 1, 15, 0));
        flights.add(new Flight(List.of(segment1, segment2)));

        // Second flight: time on the ground is more than two hours
        Segment segment3 = new Segment(LocalDateTime.of(2023, 10, 1, 10, 0),
                LocalDateTime.of(2023, 10, 1, 12, 0));
        Segment segment4 = new Segment(LocalDateTime.of(2023, 10, 1, 15, 30),
                LocalDateTime.of(2023, 10, 1, 17, 0));
        flights.add(new Flight(List.of(segment3, segment4)));

        List<Flight> filteredFlights = groundTimeFilter.filter(flights);

        assertEquals(1, filteredFlights.size());
    }

}

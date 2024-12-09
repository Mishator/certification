import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;
import com.gridnine.testing.impl.DepartureDateFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class DepartureDateFilterTest {

    private final DepartureDateFilter filter = new DepartureDateFilter();
    @Test
    void testFilter() {
        // Create a list of flights
        List<Flight> flights = Arrays.asList(
                // Flight with departure date after current time
                new Flight(Arrays.asList(
                        new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(3)),
                        new Segment(LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(6))
                )),
                // Flight with departure date before current time
                new Flight(Arrays.asList(
                        new Segment(LocalDateTime.now().minusHours(1), LocalDateTime.now().minusHours(3)),
                        new Segment(LocalDateTime.now().minusHours(4), LocalDateTime.now().minusHours(6))
                ))
        );
        // Apply the filter
        List<Flight> filteredFlights = filter.filter(flights);
        // Check the result
        Assertions.assertEquals(1, filteredFlights.size());
        Assertions.assertEquals(flights.get(0), filteredFlights.get(0));
    }

}
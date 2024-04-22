package co.udea.airline.api;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Date;

import co.udea.airline.api.controller.BookingController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import co.udea.airline.api.model.jpa.model.*;
import co.udea.airline.api.service.BookingService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class AirlineApiApplicationTests {
    @Mock
    private BookingService bookingService;

    @InjectMocks
    private BookingController bookingController;

    @Test
    void contextLoads(){
        assertTrue(true);
    }

    @Test
    void testSaveBooking(){
        MockitoAnnotations.openMocks(this);
        Booking booking = new Booking(1L, new Passenger(1L, 1L), new Date(), "Active", 100000L);

        Mockito.doNothing().when(bookingService).saveOrUpdate(booking);

        bookingController.saveBooking(booking);

        verify(bookingService).saveOrUpdate(booking);
    }
}

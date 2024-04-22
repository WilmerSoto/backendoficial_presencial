package co.udea.airline.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import co.udea.airline.api.model.jpa.model.Booking;
import co.udea.airline.api.model.jpa.repository.BookingRepository;

@SpringBootTest
class BookingServiceTest {
    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBookings() {
        List<Booking> expectedBookings = new ArrayList<>();
        when(bookingRepository.findAll()).thenReturn(expectedBookings);

        List<Booking> result = bookingService.getBookings();

        assertEquals(expectedBookings, result);
    }

    @Test
    void testGetBooking() {
        Long id = 1L;
        Booking expectedBooking = new Booking();
        when(bookingRepository.findById(id)).thenReturn(Optional.of(expectedBooking));

        Optional<Booking> result = bookingService.getBooking(id);

        assertEquals(Optional.of(expectedBooking), result);
    }

    @Test
    void testSaveOrUpdate() {
        Booking bookingToSave = new Booking();
        bookingService.saveOrUpdate(bookingToSave);

        verify(bookingRepository, times(1)).save(bookingToSave);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        bookingService.delete(id);

        verify(bookingRepository, times(1)).deleteById(id);
    }
}

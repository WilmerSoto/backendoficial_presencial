package co.udea.airline.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import co.udea.airline.api.model.jpa.model.Booking;
import co.udea.airline.api.service.BookingService;

@SpringBootTest
class BookingControllerTest {

  @Mock
  private BookingService bookingService;

  @InjectMocks
  private BookingController bookingController;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetBookings() {
    //Arrange
    List<Booking> expectedBookings = Arrays.asList(new Booking(), new Booking());
    when(bookingService.getBookings()).thenReturn(expectedBookings);

    //Act
    List<Booking> result = bookingController.getBookings();

    //Assert
    assertEquals(expectedBookings, result);
  }

  @Test
  void testGetBookingById() {
    //Arrange
    Long bookingId = 1L;
    Booking expectedBooking = new Booking();
    when(bookingService.getBooking(bookingId)).thenReturn(Optional.of(expectedBooking));

    //Act
    Optional<Booking> result = bookingController.getBookingById(bookingId);

    //Assert
    assertEquals(Optional.of(expectedBooking), result);
  }

  @Test
  void testSaveBooking() {
    //Arrange
    Booking bookingToSave = new Booking();

    //Act
    bookingController.saveBooking(bookingToSave);

    //Assert
    verify(bookingService, times(1)).saveOrUpdate(bookingToSave);
  }

  @Test
  void testDeleteBooking() {
    //Arrange
    Long bookingId = 1L;

    //Act
    bookingController.deleteBooking(bookingId);

    //Assert
    verify(bookingService, times(1)).delete(bookingId);
  }
}

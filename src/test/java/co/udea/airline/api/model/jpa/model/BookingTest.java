package co.udea.airline.api.model.jpa.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookingTest {
  @Test
  void testBookingGettersAndSetters() {
    // Arrange
    Booking booking = new Booking();
    Long expectedBookingId = 1L;
    Passenger expectedPassenger = new Passenger();
    Date expectedBookingDate = new Date(1619113200000L);
    String expectedBookingStatus = "confirmed";
    Long expectedTotalPrice = 100L;

    //Act
    booking.setBookingId(expectedBookingId);
    booking.setPassenger(expectedPassenger);
    booking.setBookingDate(expectedBookingDate);
    booking.setBookingStatus(expectedBookingStatus);
    booking.setTotalPrice(expectedTotalPrice);

    //Assert
    assertEquals(expectedBookingId, booking.getBookingId());
    assertEquals(expectedPassenger, booking.getPassenger());
    assertEquals(expectedBookingDate, booking.getBookingDate());
    assertEquals(expectedBookingStatus, booking.getBookingStatus());
    assertEquals(expectedTotalPrice, booking.getTotalPrice());
  }
}

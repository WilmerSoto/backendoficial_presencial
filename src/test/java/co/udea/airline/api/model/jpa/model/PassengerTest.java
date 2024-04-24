package co.udea.airline.api.model.jpa.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PassengerTest {
  @Test
  void testPassengerGettersAndSetters() {
    // Arrange
    Passenger passenger = new Passenger();
    Long expectedPassengerId = 1L;
    Long expectedPersonId = 2L;

    // Act
    passenger.setPassengerId(expectedPassengerId);
    passenger.setPersonId(expectedPersonId);

    // Assert
    assertEquals(expectedPassengerId, passenger.getPassengerId());
    assertEquals(expectedPersonId, passenger.getPersonId());
  }
}

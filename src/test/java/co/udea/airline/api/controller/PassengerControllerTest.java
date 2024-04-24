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

import co.udea.airline.api.model.jpa.model.Passenger;
import co.udea.airline.api.service.PassengerService;

@SpringBootTest
class PassengerControllerTest {
  @Mock
  private PassengerService passengerService;

  @InjectMocks
  private PassengerController passengerController;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetPassengers() {
    //Arrange
    List<Passenger> expectedPassengers = Arrays.asList(new Passenger(), new Passenger());
    when(passengerService.getPassengers()).thenReturn(expectedPassengers);

    //Act
    List<Passenger> result = passengerController.getPassengers();

    //Assert
    assertEquals(expectedPassengers, result);
  }

  @Test
  void testGetPassengerById() {
    //Arrange
    Long passengerId = 1L;
    Passenger expectedPassenger = new Passenger();
    when(passengerService.getPassenger(passengerId)).thenReturn(Optional.of(expectedPassenger));

    //Act
    Optional<Passenger> result = passengerController.getPassengerById(passengerId);

    //Assert
    assertEquals(Optional.of(expectedPassenger), result);
  }

  @Test
  void testSavePassenger() {
    //Arrange
    Passenger passengerToSave = new Passenger();

    //Act
    passengerController.savePassenger(passengerToSave);

    //Assert
    verify(passengerService, times(1)).saveOrUpdate(passengerToSave);
  }

  @Test
  void testDeletePassenger() {
    //Arrange
    Long passengerId = 1L;

    //Act
    passengerController.deletePassenger(passengerId);

    //Assert
    verify(passengerService, times(1)).delete(passengerId);
  }
}

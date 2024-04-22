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

import co.udea.airline.api.model.jpa.model.Passenger;
import co.udea.airline.api.model.jpa.repository.PassengerRepository;

@SpringBootTest
class PassengerServiceTest {
   
    @Mock
    private PassengerRepository passengerRepository;

    @InjectMocks
    private PassengerService passengerService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPassengers() {
        List<Passenger> expectedPassengers = new ArrayList<>();
        when(passengerRepository.findAll()).thenReturn(expectedPassengers);

        List<Passenger> result = passengerService.getPassengers();

        assertEquals(expectedPassengers, result);
    }

    @Test
    void testGetPassenger() {
        Long id = 1L;
        Passenger expectedPassenger = new Passenger();
        when(passengerRepository.findById(id)).thenReturn(Optional.of(expectedPassenger));

        Optional<Passenger> result = passengerService.getPassenger(id);

        assertEquals(Optional.of(expectedPassenger), result);
    }

    @Test
    void testSaveOrUpdate() {
        Passenger passengerToSave = new Passenger();
        passengerService.saveOrUpdate(passengerToSave);

        verify(passengerRepository, times(1)).save(passengerToSave);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        passengerService.delete(id);

        verify(passengerRepository, times(1)).deleteById(id);
    }
}

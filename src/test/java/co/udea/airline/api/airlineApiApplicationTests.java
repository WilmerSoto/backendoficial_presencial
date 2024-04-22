package co.udea.airline.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import co.udea.airline.api.model.jpa.model.*;
import co.udea.airline.api.service.BookingService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AirlineApiApplicationTests {
    @MockBean
    private BookingService bookingService;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int puerto;

    @Test
    void contextLoads(){
        assertTrue(true);
    }

    @Test
    void testSaveBooking(){
        Booking booking = new Booking(1L, new Passenger(1L, 1L), new Date(), "Active", 100000L);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Booking> requestEntity = new HttpEntity<>(booking, headers);

        restTemplate.postForObject("http://localhost:"+puerto+"/v1/booking/booking", requestEntity, void.class);

        verify(bookingService).saveOrUpdate(booking);
    }
}

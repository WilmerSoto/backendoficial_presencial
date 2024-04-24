package co.udea.airline.api.model.jpa.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonTest {
    
    @Test
    void testPersonGettersAndSetters() {

        //Arrange
        Person person = new Person();
        Long expectedPersonId = 1L;
        String expectedIdNumber = "123456789";
        String expectedFirstName = "John";
        String expectedLastName = "Doe";
        Character expectedGenre = 'M';
        Date expectedBirthDate = new Date(1619113200000L);
        String expectedPhoneNumber = "123456789";
        String expectedCountry = "USA";
        String expectedProvince = "California";
        String expectedCity = "Los Angeles";
        String expectedResidence = "123 Main St";
        String expectedEmail = "john.doe@example.com";
        String expectedPassword = "password123";

        //Act
        person.setPersonId(expectedPersonId);
        person.setIdNumber(expectedIdNumber);
        person.setFirstName(expectedFirstName);
        person.setLastName(expectedLastName);
        person.setGenre(expectedGenre);
        person.setBirthDate(expectedBirthDate);
        person.setPhoneNumber(expectedPhoneNumber);
        person.setCountry(expectedCountry);
        person.setProvince(expectedProvince);
        person.setCity(expectedCity);
        person.setResidence(expectedResidence);
        person.setEmail(expectedEmail);
        person.setPassword(expectedPassword);

        //Assert 
        assertEquals(expectedPersonId, person.getPersonId());
        assertEquals(expectedIdNumber, person.getIdNumber());
        assertEquals(expectedFirstName, person.getFirstName());
        assertEquals(expectedLastName, person.getLastName());
        assertEquals(expectedGenre, person.getGenre());
        assertEquals(expectedBirthDate, person.getBirthDate());
        assertEquals(expectedPhoneNumber, person.getPhoneNumber());
        assertEquals(expectedCountry, person.getCountry());
        assertEquals(expectedProvince, person.getProvince());
        assertEquals(expectedCity, person.getCity());
        assertEquals(expectedResidence, person.getResidence());
        assertEquals(expectedEmail, person.getEmail());
        assertEquals(expectedPassword, person.getPassword());
    }
    
}

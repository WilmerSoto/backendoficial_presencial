package co.udea.airline.api.model.jpa.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;

public class PersonTest {
    @Test
    void testGetBirthDate() {
        Person person = new Person();
        Date expected = new Date(1619113200000L);
        person.setBirthDate(expected);
        assertEquals(expected, person.getBirthDate());
    }

    @Test
    void testGetCity() {
        Person person = new Person();
        String expected = "Medellin";
        person.setCity(expected);
        assertEquals(expected, person.getCity());
    }

    @Test
    void testGetCountry() {
        Person person = new Person();
        String expected = "Colombia";
        person.setCountry(expected);
        assertEquals(expected, person.getCountry());
    }

    @Test
    void testGetEmail() {
        Person person = new Person();
        String expected = "juan@gmail.com";
        person.setEmail(expected);
        assertEquals(expected, person.getEmail());
    }

    @Test
    void testGetFirstName() {
        Person person = new Person();
        String expected = "juan";
        person.setFirstName(expected);
        assertEquals(expected, person.getFirstName());
    }

    @Test
    void testGetIdNumber() {
        Person person = new Person();
        String expected = "123456789";
        person.setIdNumber(expected);
        assertEquals(expected, person.getIdNumber());
    }

    @Test
    void testGetLastName() {
        Person person = new Person();
        String expected = "Escobar";
        person.setLastName(expected);
        assertEquals(expected, person.getLastName());
    }

    @Test
    void testGetPassword() {
        Person person = new Person();
        String expected = "1234";
        person.setPassword(expected);
        assertEquals(expected, person.getPassword());
    }

    @Test
    void testGetPersonId() {
        Person person = new Person();
        Long expectedId = 1L;
        person.setPersonId(expectedId);
        assertEquals(expectedId, person.getPersonId());
    }

    @Test
    void testGetPhoneNumber() {
        Person person = new Person();
        String expected = "123456789";
        person.setPhoneNumber(expected);
        assertEquals(expected, person.getPhoneNumber());
    }

    @Test
    void testGetProvince() {
        Person person = new Person();
        String expected = "Province";
        person.setProvince(expected);
        assertEquals(expected, person.getProvince());
    }

    @Test
    void testGetResidence() {
        Person person = new Person();
        String expected = "Residence";
        person.setResidence(expected);
        assertEquals(expected, person.getResidence());
    }
    
}

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

import co.udea.airline.api.model.jpa.model.Person;
import co.udea.airline.api.service.PersonService;

@SpringBootTest
class PersonControllerTest {
  @Mock
  private PersonService personService;

  @InjectMocks
  private PersonController personController;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetPersons() {
    // Arrange
    List<Person> expectedPersons = Arrays.asList(new Person(), new Person());
    when(personService.getPersons()).thenReturn(expectedPersons);

    // Act
    List<Person> result = personController.getPersons();

    // Assert
    assertEquals(expectedPersons, result);
  }

  @Test
  void testGetPersonById() {
    // Arrange
    long personId = 1L;
    Person expectedPerson = new Person();
    when(personService.getPerson(personId)).thenReturn(Optional.of(expectedPerson));

    // Act
    Optional<Person> result = personController.getPersonById(personId);

    // Assert
    assertEquals(Optional.of(expectedPerson), result);
  }

  @Test
  void testSavePerson() {
    // Arrange
    Person personToSave = new Person();

    // Act
    personController.savePerson(personToSave);

    // Assert
    verify(personService, times(1)).saveOrUpdate(personToSave);
  }

  @Test
  void testDeletePerson() {
    // Arrange
    Long personId = 1L;

    // Act
    personController.deletePerson(personId);

    // Assert
    verify(personService, times(1)).delete(personId);
  }
}

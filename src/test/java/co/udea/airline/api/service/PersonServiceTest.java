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

import co.udea.airline.api.model.jpa.model.Person;
import co.udea.airline.api.model.jpa.repository.PersonRepository;

@SpringBootTest
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        personService.delete(id);

        verify(personRepository, times(1)).deleteById(id);
    }

    @Test
    void testGetPerson() {
        Long id = 1L;
        Person expectedPerson = new Person();
        when(personRepository.findById(id)).thenReturn(Optional.of(expectedPerson));

        Optional<Person> result = personService.getPerson(id);

        assertEquals(Optional.of(expectedPerson), result);
    }

    @Test
    void testGetPersons() {
        List<Person> expectedPersons = new ArrayList<>();
        when(personRepository.findAll()).thenReturn(expectedPersons);

        List<Person> result = personService.getPersons();

        assertEquals(expectedPersons, result);
    }

    @Test
    void testSaveOrUpdate() {
        Person personToSave = new Person();
        personService.saveOrUpdate(personToSave);

        verify(personRepository, times(1)).save(personToSave);
    }
}

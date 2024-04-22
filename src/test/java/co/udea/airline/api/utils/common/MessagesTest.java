package co.udea.airline.api.utils.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

public class MessagesTest {
    private Messages messages;

    @Mock
    private MessageSource messageSource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        messages = new Messages();
        messages.setMessageSource(messageSource);
        messages.init();
    }

    @Test
    public void testGetMessage_Success() {
        String code = "test.message";
        String expectedMessage = "Test Message";
        when(messageSource.getMessage(code, null, Locale.ENGLISH)).thenReturn(expectedMessage);

        String actualMessage = messages.get(code);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testGetMessage_NoSuchMessageException() {
        String code = "nonexistent.message";
        when(messageSource.getMessage(code, null, Locale.ENGLISH)).thenThrow(NoSuchMessageException.class);

        String actualMessage = messages.get(code);

        assertEquals("No hay mensaje disponible para mostrar.", actualMessage);
    }
}

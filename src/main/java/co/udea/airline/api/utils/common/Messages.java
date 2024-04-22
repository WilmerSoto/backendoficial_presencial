package co.udea.airline.api.utils.common;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Helper to simplify accessing i18n messages in code.
 */
@Component
@RequiredArgsConstructor
public class Messages {

    private MessageSource messageSource;

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private MessageSourceAccessor accessor;

    @PostConstruct
    public void init() {
        accessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);
    }

    public String get(String code) {
        try {
            return accessor.getMessage(code);
        } catch (NoSuchMessageException exception) {
            return "No hay mensaje disponible para mostrar.";
        }

    }

}
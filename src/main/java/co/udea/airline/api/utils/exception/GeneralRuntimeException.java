package co.udea.airline.api.utils.exception;

/**
 * Generic abstract exception created to identify all Exceptions.
 */
public class GeneralRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;
    private String translationKey;


    public GeneralRuntimeException(String message) {
        super(message);
        this.message = message;
    }

    public GeneralRuntimeException(String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
    }


    public GeneralRuntimeException(String message, String translationKey) {
        super(message);
        this.message = message;
        this.translationKey = translationKey;
    }


    public String getTranslationKey() {
        return translationKey;
    }

    @Override
    public String getMessage() {
        return message;
    }

}

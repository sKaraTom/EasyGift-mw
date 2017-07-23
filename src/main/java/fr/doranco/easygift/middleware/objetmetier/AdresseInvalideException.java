package fr.doranco.easygift.middleware.objetmetier;

public class AdresseInvalideException extends Exception {

    public AdresseInvalideException() {
    }

    public AdresseInvalideException(String message) {
        super(message);
    }

    public AdresseInvalideException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdresseInvalideException(Throwable cause) {
        super(cause);
    }

}

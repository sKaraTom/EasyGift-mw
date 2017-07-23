package fr.doranco.easygift.middleware.objetmetier;

public class AdresseExistanteException extends Exception {

    public AdresseExistanteException() {
        super();
    }

    public AdresseExistanteException(String message) {
        super(message);
    }

    public AdresseExistanteException(String message, Throwable cause) {
        super(message, cause);
    }

}

package fr.doranco.easygift.middleware.objetmetier;

public class AdresseInexistanteException extends Exception {

	private static final long serialVersionUID = 1L;

	public AdresseInexistanteException() {
		super();
	}

	public AdresseInexistanteException(String message, Throwable cause) {
		super(message, cause);
	}

	public AdresseInexistanteException(String message) {
		super(message);
	}

	public AdresseInexistanteException(Throwable cause) {
		super(cause);
	}
	
}

package fr.doranco.easygift.middleware.objetmetier.compte;

public class CompteInvalide extends Exception {

	private static final long serialVersionUID = 1L;

	public CompteInvalide() {
		super();
	}

	public CompteInvalide(String message, Throwable cause) {
		super(message, cause);
	}

	public CompteInvalide(String message) {
		super(message);
	}

	public CompteInvalide(Throwable cause) {
		super(cause);
	}

}

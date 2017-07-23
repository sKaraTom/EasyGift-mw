package fr.doranco.easygift.middleware.objetmetier.abonne;

public class AbonneExistantException extends Exception {

	private static final long serialVersionUID = 1L;

	public AbonneExistantException() {
		super();
	}

	public AbonneExistantException(String message, Throwable cause) {
		super(message, cause);
	}

	public AbonneExistantException(String message) {
		super(message);
	}

	public AbonneExistantException(Throwable cause) {
		super(cause);
		// Pong
	}

}

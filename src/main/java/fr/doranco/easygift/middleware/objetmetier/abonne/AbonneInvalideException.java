package fr.doranco.easygift.middleware.objetmetier.abonne;

public class AbonneInvalideException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbonneInvalideException() {
		super();
	}

	public AbonneInvalideException(String message, Throwable cause) {
		super(message, cause);
	}

	public AbonneInvalideException(String message) {
		super(message);
	}

	public AbonneInvalideException(Throwable cause) {
		super(cause);
		// Pong!
	}
	
	

}

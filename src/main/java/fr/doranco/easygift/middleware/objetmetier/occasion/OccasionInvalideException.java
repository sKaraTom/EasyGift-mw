package fr.doranco.easygift.middleware.objetmetier.occasion;

public class OccasionInvalideException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public OccasionInvalideException(final Occasion occasionInvalide) {
		super();
	}

	public OccasionInvalideException(String message, Throwable cause) {
		super(message, cause);
	}

	public OccasionInvalideException(String message) {
		super(message);
	}

	public OccasionInvalideException(Throwable cause) {
		super(cause);
	}

}

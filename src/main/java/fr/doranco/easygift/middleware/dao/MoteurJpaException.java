package fr.doranco.easygift.middleware.dao;

public class MoteurJpaException extends Error {

	private static final long serialVersionUID = 1L;

	public MoteurJpaException() {
		super();
	}

	public MoteurJpaException(String message, Throwable cause) {
		super(message, cause);
	}

	public MoteurJpaException(String message) {
		super(message);
	}

	public MoteurJpaException(Throwable cause) {
		super(cause);
	}

}

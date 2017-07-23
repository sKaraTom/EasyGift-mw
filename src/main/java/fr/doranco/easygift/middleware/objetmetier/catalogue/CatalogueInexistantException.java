package fr.doranco.easygift.middleware.objetmetier.catalogue;

public class CatalogueInexistantException extends Exception {

	private static final long serialVersionUID = 1L;

	public CatalogueInexistantException() {
		super();
	}

	public CatalogueInexistantException(String message, Throwable cause) {
		super(message, cause);
	}

	public CatalogueInexistantException(String message) {
		super(message);
	}

	public CatalogueInexistantException(Throwable cause) {
		super(cause);
	}

}

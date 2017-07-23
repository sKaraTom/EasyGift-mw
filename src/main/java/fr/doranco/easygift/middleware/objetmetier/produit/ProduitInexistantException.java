package fr.doranco.easygift.middleware.objetmetier.produit;

public class ProduitInexistantException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProduitInexistantException() {
		super();
	}

	public ProduitInexistantException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProduitInexistantException(String message) {
		super(message);
	}

	public ProduitInexistantException(Throwable cause) {
		super(cause);
	}
	
}

package fr.doranco.easygift.middleware.objetmetier.produit;

public class ProduitDejaExistantException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProduitDejaExistantException() {
		super();
	}

	public ProduitDejaExistantException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProduitDejaExistantException(String message) {
		super(message);
	}

	public ProduitDejaExistantException(Throwable cause) {
		super(cause);
	}

}

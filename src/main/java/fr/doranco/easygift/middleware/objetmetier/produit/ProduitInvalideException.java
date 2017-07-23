package fr.doranco.easygift.middleware.objetmetier.produit;

public class ProduitInvalideException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProduitInvalideException() {
		super();
	}

	public ProduitInvalideException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProduitInvalideException(String message) {
		super(message);
	}

	public ProduitInvalideException(Throwable cause) {
		super(cause);
	}

}

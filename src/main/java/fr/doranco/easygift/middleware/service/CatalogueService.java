package fr.doranco.easygift.middleware.service;

import java.text.MessageFormat;
import java.time.Instant;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;

import fr.doranco.easygift.middleware.dao.CatalogueDao;
import fr.doranco.easygift.middleware.objetmetier.catalogue.Catalogue;
import fr.doranco.easygift.middleware.objetmetier.catalogue.CatalogueInexistantException;
import fr.doranco.easygift.middleware.objetmetier.produit.Produit;
import fr.doranco.easygift.middleware.objetmetier.produit.ProduitDejaExistantException;
import fr.doranco.easygift.middleware.objetmetier.produit.ProduitInexistantException;
import fr.doranco.easygift.middleware.objetmetier.produit.ProduitInvalideException;

@Stateless
public class CatalogueService {

	@EJB
	private CatalogueDao catalogueDao;
	
	public void ajouterProduitAuCatalogue(final Produit produit, final String referenceCatalogue)
			throws ProduitInvalideException, ProduitDejaExistantException,
				CatalogueInexistantException {
		
		/*
		 * Notre produit doit disposer au minimum de : - Une référence - Une
		 * date de création - Un label
		 */
		validerProduit(produit);
		
		// Nous retrouvons le catalogue.
		Catalogue catalogue = catalogueDao.obtenirCatalogue(referenceCatalogue);

		// Notre produit doit être unique.
		if (catalogue.getProduits().containsKey(produit.getReference())) {
			final String message = MessageFormat.format("Le produit {0} existe déjà.", produit);
			throw new ProduitDejaExistantException(message);
		}
		
		// Nous fixons la date de création à aujourd'hui
		produit.setDateCreation(Instant.now());

		// Nous ajoutons le produit au dictionnaire des produits du catalogue.
		catalogue.getProduits().put(produit.getReference(), produit);

	}

	public void retirerProduit(final String reference, final Catalogue catalogue) throws ProduitInexistantException {

		if (!catalogue.getProduits().containsKey(reference)) {
			final String message = MessageFormat.format("Le produit de référence {0} n''existe pas.", reference);
			throw new ProduitInexistantException(message);
		}

		catalogue.getProduits().remove(reference);
	}

	public void modifierProduit(final Produit produit, final Catalogue catalogue)
			throws ProduitInvalideException, ProduitInexistantException {

		validerProduit(produit);

		if (!catalogue.getProduits().containsKey(produit.getReference())) {
			final String message = MessageFormat.format("Le produit à modifier {0} n''existe pas.", produit);
			throw new ProduitInexistantException(message);
		}
		
		catalogue.getProduits().put(produit.getReference(), produit);
	}
	
	private void validerProduit(final Produit produit) throws ProduitInvalideException {

		if (produit == null)
			throw new ProduitInvalideException("Le produit à ajouter ne peut être null.");

		if (StringUtils.isBlank(produit.getReference())) {
			final String message = MessageFormat.format("Le produit {0} ne dispose pas d'une référence valide.",
					produit);
			throw new ProduitInvalideException(message);
		}

		if (StringUtils.isBlank(produit.getLabel())) {
			final String message = MessageFormat.format("Le produit {0} ne dispose pas d'un label valide.", produit);
			throw new ProduitInvalideException(message);
		}

	}

}

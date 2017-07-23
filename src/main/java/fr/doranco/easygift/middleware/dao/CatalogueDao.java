package fr.doranco.easygift.middleware.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import fr.doranco.easygift.middleware.objetmetier.catalogue.Catalogue;
import fr.doranco.easygift.middleware.objetmetier.catalogue.CatalogueInexistantException;

@Stateless
public class CatalogueDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Catalogue> obtenirCataloguesParSQL() {
		
		final String requeteSQL = "SELECT * FROM T_CATALOGUE";
		
 		final Query requete = entityManager.createNativeQuery(requeteSQL);

		// /!\ ATTENTION ! /!\ -- Un cast non check.
		final List<Catalogue> catalogues = requete.getResultList();
		
		return catalogues;
	}
	
	public List<Catalogue> obtenirCataloguesParJPQL() {
		
		final String requeteJPQL = "SELECT c FROM Catalogue c";
		
		final TypedQuery<Catalogue> requete = 
				entityManager.createQuery(requeteJPQL, Catalogue.class);
		
		return requete.getResultList();
	}
	
	public List<Catalogue> obtenirCataloguesCriteria() {

		/*
		 * J'obtiens un constructeur de l'API Criteria.
		 * C'est un facilitateur d'instanciation d'opération,
		 * de condition ou de fonction de l'API.
		 * Par exemple, il me permet de créer facilement une condition de jointure.
		 */
		final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		
		// Je prépare une requete Critéria
		final CriteriaQuery<Catalogue> requeteCriteria
			= cb.createQuery(Catalogue.class);
		
		// Je crée un "root" de sélection de manière programmatique.
		requeteCriteria.from(Catalogue.class);

		final TypedQuery<Catalogue> requete =
				entityManager.createQuery(requeteCriteria);	
		
		// Je joue la requête et retourne son résultat.
		return requete.getResultList(); 
	}
	
	public Catalogue obtenirCatalogue(final String reference)
			throws CatalogueInexistantException {
		
		Catalogue catalogue = null;
		
		try {
			catalogue = entityManager.find(Catalogue.class, reference);
		} catch (final IllegalArgumentException e) {
			throw new MoteurJpaException();
		}
		
		if (catalogue == null)
			throw new CatalogueInexistantException();
		
		return catalogue;
	}
	
	public void creerCatalogue(final Catalogue catalogue) {
		
		entityManager.persist(catalogue);
	}
	
	public void modifierCatalogue(final Catalogue catalogue) {
		
		entityManager.merge(catalogue);
	}
	
	public void supprimerCatalogue(final String reference) {
		
		Catalogue catalogue = entityManager.getReference(Catalogue.class, reference);
		
		entityManager.remove(catalogue);
	}
	
}

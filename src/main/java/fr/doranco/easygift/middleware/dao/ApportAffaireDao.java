package fr.doranco.easygift.middleware.dao;

import java.time.Instant;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import fr.doranco.easygift.middleware.objetmetier.apport.ApportAffaire;

@Stateless
@Transactional
public class ApportAffaireDao {
	
	private static final ResourceBundle RSC = ResourceBundle.getBundle(ApportAffaireDao.class.getName());
	
	@PersistenceContext
	private EntityManager em;
	
	public List<ApportAffaire> obtenirApportsAffaireSurPeriode(final Instant dateDebut, final Instant dateFin, final String referenceAffilie) {
		
		if (dateDebut.isAfter(dateFin))
			throw new Error(RSC.getString("erreur.wootWoot"));
		
		// J'écris la requête
		final String requeteJPQL = RSC.getString("jpa.requete.pasbelle");
		
		// J'obtiens et je prépare la requête
		final TypedQuery<ApportAffaire> requete =
				em.createQuery(requeteJPQL, ApportAffaire.class);
		
		requete.setParameter("dateDebut", dateDebut);
		requete.setParameter("dateFin", dateFin);
		requete.setParameter("referenceAffilie", referenceAffilie);
		
		// Je joue la requête
		return requete.getResultList();
	}

}

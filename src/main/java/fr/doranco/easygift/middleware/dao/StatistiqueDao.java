package fr.doranco.easygift.middleware.dao;

import java.time.Instant;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import fr.doranco.easygift.middleware.objetmetier.statistique.StatistiqueApportAffairePK;
import fr.doranco.easygift.middleware.objetmetier.statistique.StatistiqueApportAffairePeriodique;

@Stateless
@Transactional
public class StatistiqueDao {

	private EntityManager em;
	
	public StatistiqueApportAffairePeriodique obtenirStat(final Instant dateDebut,
			final Instant dateFin, final String referenceAffilie) {
		
		final StatistiqueApportAffairePK pk = new StatistiqueApportAffairePK(dateDebut, dateFin, referenceAffilie);
		
		return em.find(StatistiqueApportAffairePeriodique.class, pk);
	}
	
}

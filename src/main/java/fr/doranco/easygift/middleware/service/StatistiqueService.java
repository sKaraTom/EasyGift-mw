package fr.doranco.easygift.middleware.service;

import java.time.Instant;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import fr.doranco.easygift.middleware.objetmetier.apport.ApportAffaire;
import fr.doranco.easygift.middleware.objetmetier.apport.HistoriqueApportAffaire;
import fr.doranco.easygift.middleware.objetmetier.statistique.StatistiqueApportAffairePeriodique;

@Stateless
@Transactional
public class StatistiqueService {
	
	@EJB
	private AffilieService affilieService;

	public StatistiqueApportAffairePeriodique compilerStatsApportAffaire(final Instant dateDebut, final Instant dateFin, final String referenceAffilie) {
		
		// Je valide les paramètres.
		
		// Je vais rechercher tous les apports d'affaires de mon partenaire.
		final HistoriqueApportAffaire historique = affilieService.obtenirApportsAffaireSurPeriode(dateDebut, dateFin, referenceAffilie);
		
		final Double volume = historique.getHistoriqueApportsAffaire()
			.stream()
			.mapToDouble(ApportAffaire::getMontant)
			.sum();
		
		return new StatistiqueApportAffairePeriodique(
					dateDebut, dateFin,
					referenceAffilie, volume
				);
	}
	
}

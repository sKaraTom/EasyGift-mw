package fr.doranco.easygift.middleware.service;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import fr.doranco.easygift.middleware.dao.ApportAffaireDao;
import fr.doranco.easygift.middleware.objetmetier.apport.ApportAffaire;
import fr.doranco.easygift.middleware.objetmetier.apport.HistoriqueApportAffaire;

@Stateless
@Transactional
public class AffilieService {
	
	@EJB
	private ApportAffaireDao apportAffaireDao;

	public HistoriqueApportAffaire obtenirApportsAffaireSurPeriode(final Instant dateDebut,
			final Instant dateFin, final String referenceAffilie) {
		
		// Je pourrais valider les paramètres.
		
		final List<ApportAffaire> apportsAffaire =
				apportAffaireDao.obtenirApportsAffaireSurPeriode(dateDebut, dateFin, referenceAffilie);
		
		final HistoriqueApportAffaire historique =
				new HistoriqueApportAffaire(
							new HashSet<>(apportsAffaire),
							referenceAffilie
						);
		
		return historique;
	}
	
}

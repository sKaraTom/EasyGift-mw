package fr.doranco.easygift.middleware.service;

import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import fr.doranco.easygift.middleware.dao.SuggestionDao;
import fr.doranco.easygift.middleware.objetmetier.suggestion.Evaluation;
import fr.doranco.easygift.middleware.objetmetier.suggestion.Suggestion;

@Stateless
@Transactional
public class EvaluationService {

	@EJB
	private SuggestionDao suggestionDao;
	
	public void evaluerSuggestion(final UUID identifiantSuggestion, final Evaluation evaluation) {

		// Valider les paramètres tsoin-tsoin.
		
		final Suggestion suggestion =
				suggestionDao.obtenirSuggestion(identifiantSuggestion);
		
		suggestion.getEvaluations().add(evaluation);
		
		suggestionDao.modifierSuggestion(suggestion);
	}
	
}

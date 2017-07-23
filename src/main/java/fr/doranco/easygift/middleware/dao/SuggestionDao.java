package fr.doranco.easygift.middleware.dao;

import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import fr.doranco.easygift.middleware.objetmetier.suggestion.Suggestion;

@Stateless
@Transactional
public class SuggestionDao {
	
	@PersistenceContext
	private EntityManager em;

	public Suggestion obtenirSuggestion(final UUID identifiantSuggestion) {
		
		return em.find(Suggestion.class, identifiantSuggestion);
	}
	
	public void modifierSuggestion(final Suggestion suggestion) {
		
		em.merge(suggestion);
	}
	
}

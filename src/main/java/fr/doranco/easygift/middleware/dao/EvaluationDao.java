package fr.doranco.easygift.middleware.dao;

import fr.doranco.easygift.middleware.objetmetier.suggestion.Evaluation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Stateless
@Transactional
public class EvaluationDao {
	
	@PersistenceContext
	private EntityManager em;

	public void ajouterEvaluation(final Evaluation evaluation) {

	    em.persist(evaluation);
    }

}

package fr.doranco.easygift.middleware.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import fr.doranco.easygift.middleware.dao.entity.OccasionJpaEntity;
import fr.doranco.easygift.middleware.objetmetier.occasion.Occasion;
import fr.doranco.easygift.middleware.objetmetier.occasion.OccasionExistanteException;

@Stateless
@Transactional
public class OccasionDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public Occasion ajouterOccasion(final Occasion occasion)
			throws OccasionExistanteException {
		
		final OccasionJpaEntity entite = transformerObjetMetierEnEntite(occasion);
		
		try {
			em.persist(entite);
		} catch (final EntityExistsException e) {
			throw new OccasionExistanteException(e);
		} catch (final IllegalArgumentException e) {
			throw new MoteurJpaException("T'es trop bête.");
		}
		
		return occasion;
	}
	
	private OccasionJpaEntity transformerObjetMetierEnEntite(final Occasion occasion) {
		
		OccasionJpaEntity entite = new OccasionJpaEntity();
		
		entite.setCode(occasion.getCode());
		entite.setDateDebut(occasion.getDateDebut());
		entite.setDateFin(occasion.getDateFin());
		entite.setDescription(occasion.getDescription());
		entite.setLabel(occasion.getLabel());
		
		return entite;
	}

}

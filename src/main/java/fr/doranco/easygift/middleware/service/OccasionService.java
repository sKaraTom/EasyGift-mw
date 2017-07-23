package fr.doranco.easygift.middleware.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import fr.doranco.easygift.middleware.dao.OccasionDao;
import fr.doranco.easygift.middleware.objetmetier.occasion.Occasion;
import fr.doranco.easygift.middleware.objetmetier.occasion.OccasionExistanteException;
import fr.doranco.easygift.middleware.objetmetier.occasion.OccasionInvalideException;

@Stateless
@Transactional
public class OccasionService {
	
	@EJB
	private OccasionDao occasionDao;

	public Occasion ajouterOccasion(final Occasion occasion)
			throws OccasionInvalideException, OccasionExistanteException {
		
		// Nous validons notre occasion.
		valider(occasion);
		
		// Nous générons un code d'occasion unique.
		occasion.setCode(RandomStringUtils.randomAlphanumeric(6));
		
		// Nous persistons notre occasion.
		return occasionDao.ajouterOccasion(occasion);
	}
	
	private void valider(final Occasion occasion)
			throws OccasionInvalideException {
		
		if (occasion.getCode() != null)
			throw new OccasionInvalideException("Une occasion à crée ne doit pas disposer de code.");
		
		if (StringUtils.isBlank(occasion.getLabel()))
			throw new OccasionInvalideException("Le label d'une occasion à créer ne peut être null.");
		
		// Nous utilisons un opérateur XOR pour notre condition.
		/*
		 * Table du XOR si : 
		 * 
		 * if ( a ^ b )
		 * 
		 * 		b	|	true	|	false	|
		 * 	a		|			|			|
		 * 	_________________________________
		 * 	true	|	false	|	true	|
		 * 	_________________________________
		 * 	false	|	true	|	false	|
		 */
		if (occasion.getDateDebut() == null ^ occasion.getDateFin() == null)
			throw new OccasionInvalideException("Une occasion à créer doit disposer d'une période consistante ou être permanente.");
		
		// Si mon occasion est périodique, alors je vérifie les dates.
		if (occasion.getDateDebut() != null && occasion.getDateDebut().after(occasion.getDateFin()))
			throw new OccasionInvalideException("Une occasion à créer doit disposer d'une période consistante.");
		
	}
	
}

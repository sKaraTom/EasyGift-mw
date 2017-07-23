package fr.doranco.easygift.middleware.dao;

import javax.ejb.Stateless;
import javax.mail.internet.InternetAddress;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import fr.doranco.easygift.middleware.objetmetier.abonne.Abonne;

@Stateless
@Transactional
public class AbonneDao {
	
	@PersistenceContext(name="EasyGiftPU")
	private EntityManager entityManager;
	
	public Abonne obtenirAbonne(final InternetAddress mail) {
		
		return entityManager.find(Abonne.class, mail);
	}
	
	public void ajouterAbonne(final Abonne abonne){
		
		entityManager.persist(abonne);
	}
	
	public void modifierAbonne(final Abonne abonne) {
		
		entityManager.merge(abonne);
	}
	
	public void supprimerAbonne(final InternetAddress mail) {
		
		final Abonne abonneASupprime =
				entityManager.getReference(Abonne.class, mail);
		
		entityManager.remove(abonneASupprime);
	}
	
	public boolean contenir(final InternetAddress mail){
		
		return false;
	}
	
}

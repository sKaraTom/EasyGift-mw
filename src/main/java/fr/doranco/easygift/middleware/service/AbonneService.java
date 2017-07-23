package fr.doranco.easygift.middleware.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.internet.AddressException;

import fr.doranco.easygift.middleware.dao.AbonneDao;
import fr.doranco.easygift.middleware.objetmetier.abonne.Abonne;
import fr.doranco.easygift.middleware.objetmetier.abonne.AbonneExistantException;
import fr.doranco.easygift.middleware.objetmetier.abonne.AbonneInvalideException;

@Stateless
public class AbonneService {
		
		@EJB
		private AbonneDao abonneDao;
		
		// Ping ?
		public void abonner(Abonne abonne) 
				throws AbonneInvalideException, AbonneExistantException{
			
			if(abonne == null){
				throw new AbonneInvalideException("Abonné Null");			
			}
			try {
				abonne.getMail().validate();
			} catch (AddressException e) {
				throw new AbonneInvalideException(e);
			}
			if(abonneDao.contenir(abonne.getMail())){
				throw new AbonneExistantException();
			}
			
			abonneDao.ajouterAbonne(abonne);
			
		}
}

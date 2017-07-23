package fr.doranco.easygift.middleware.dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import fr.doranco.easygift.middleware.objetmetier.compte.Compte;
import fr.doranco.easygift.middleware.objetmetier.compte.CompteInexistantException;

@Stateless
public class CompteDao {

	private static Map<String, Compte> COMPTES;
	
	{
		COMPTES = new HashMap<>();
		COMPTES.put("TOTO", new Compte(null, "TOTO", "TOTO"));
	}
	
	public boolean contenir(final Compte compte) {
		
		return COMPTES.containsKey(compte.getIdentifiant());
	}

	public Compte obtenir(final String identifiant)
		throws CompteInexistantException {

		Compte compte = COMPTES.get(identifiant);
		if ( compte == null )
			throw new CompteInexistantException("Compte inconnu");
	
		return compte;
	}

	public void ajouter(final Compte compte) {
		
		COMPTES.put(compte.getIdentifiant(), compte);
	}
	
}

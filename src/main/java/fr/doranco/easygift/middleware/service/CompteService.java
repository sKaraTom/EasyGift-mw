package fr.doranco.easygift.middleware.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.internet.AddressException;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;

import fr.doranco.easygift.middleware.dao.CompteDao;
import fr.doranco.easygift.middleware.objetmetier.client.Client;
import fr.doranco.easygift.middleware.objetmetier.client.ClientInvalideException;
import fr.doranco.easygift.middleware.objetmetier.compte.Compte;
import fr.doranco.easygift.middleware.objetmetier.compte.CompteDejaExistantException;
import fr.doranco.easygift.middleware.objetmetier.compte.CompteInexistantException;
import fr.doranco.easygift.middleware.objetmetier.compte.CompteInvalideException;

@Stateless
@Transactional
public class CompteService {

	@EJB
	private CompteDao compteDao;
	
//	TxType.NEVER,			--> Nous ne créerons JAMAIS de transaction
//	TxType.MANDATORY		--> Création d'une nouvelle transaction obligatoire
//	TxType.NOT_SUPPORTED	--> Nous crérons JAMAIS de transaction et ne veut pas etre appelé au sein d'une transaction.
//	TxType.REQUIRED			--> N'accepte d'être appelé que par une méthode transactionelle.
//	TxType.REQUIRES_NEW		--> Instancie toujours une nouvelle transaction.
//	TxType.SUPPORTS			--> Nous ne créerons pas de transaction mais nous acceptons d'être appelé dans une transaction.
	
	public void creerCompte(final Compte compte)
			throws CompteInvalideException, CompteDejaExistantException {
		
		validerCompte(compte);
		
		if (compteDao.contenir(compte))
			throw new CompteDejaExistantException("Le compte à créer existe déjà.");
		
		compteDao.ajouter(compte);
	}
	
	public void connecter(final Compte compte)
		throws CompteInvalideException, CompteInexistantException {
		
		if ( compte == null )
			throw new CompteInvalideException("connexion impossible");
	
		Compte compteValide = compteDao.obtenir(compte.getIdentifiant());
		
		// assert compteValide.getIdentifiant().equals(compte.getIdentifiant());
		
		if (!compteValide.getMotDePasse().equals(compte.getMotDePasse()) ||
			!compteValide.getIdentifiant().equals(compte.getIdentifiant()))
			throw new CompteInvalideException("connexion impossible");

		compte.setConnecte(true);
	}

	private void validerCompte(final Compte compte)
			throws CompteInvalideException {
	
		if (compte == null)
			throw new CompteInvalideException("Le compte ne peut être null.");
		
		if (StringUtils.isBlank(compte.getIdentifiant()))
			throw new CompteInvalideException("L''identifiant du compte ne peut valoir null/blanc.");
		
		if (StringUtils.isBlank(compte.getMotDePasse()))
			throw new CompteInvalideException("Le mot de passe du compte ne peut valoir null/blanc.");
		
		try {
			validerClient(compte.getClient());
		} catch (final ClientInvalideException clientInvalideException) {
			throw new CompteInvalideException(clientInvalideException);
		}
	}
	
	public void validerClient(final Client client) throws ClientInvalideException {
		
		if (client == null)
			throw new ClientInvalideException("Le client lié au compte ne peut être null.");
		
		try {
			client.getEmail().validate();
		} catch (AddressException adresseInvalideException) {
			throw new ClientInvalideException(adresseInvalideException);
		}
		
		// Je continue ma validation
		
	}
	
}

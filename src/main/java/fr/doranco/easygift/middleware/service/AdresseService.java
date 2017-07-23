package fr.doranco.easygift.middleware.service;

import fr.doranco.easygift.middleware.objetmetier.Adresse;
import fr.doranco.easygift.middleware.objetmetier.AdresseExistanteException;
import fr.doranco.easygift.middleware.objetmetier.AdresseInexistanteException;
import fr.doranco.easygift.middleware.objetmetier.AdresseInvalideException;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Stateless
@Transactional
public class AdresseService {

	// TODO : Référentiel des adresses à refactorer en un DAO.
	private final static List<Adresse> ADRESSES = new ArrayList<>();

	public List<Adresse> obtenirAdresses() {

		return ADRESSES;
	}
	
	public Adresse obtenirAdresse(final UUID identifiantAdresse)
			throws AdresseInexistanteException {
		
		return ADRESSES
				.parallelStream()
				.filter(a -> a.getUuid().equals(identifiantAdresse))
				.findAny()
				.orElseThrow(AdresseInexistanteException::new);
	}
	
	public void creerAdresse(final Adresse adresse)
            throws AdresseExistanteException, AdresseInvalideException {

	    // Vérifier que l'adresse existe déjà.
        if (ADRESSES.contains(adresse))
            throw new AdresseExistanteException();

        // Vérifier la valider de l'adresse.
        validerAdresse(adresse);

		// Ajouter la nouvelle adresse à mon référentiel.
		ADRESSES.add(adresse);
	}

	private void validerAdresse(final Adresse adresse) throws AdresseInvalideException {

	    if (StringUtils.isBlank(adresse.getLigne1()))
            throw new AdresseInvalideException();

	    // Je valide pleins de champs tout çà, tout çà.

    }
	
}

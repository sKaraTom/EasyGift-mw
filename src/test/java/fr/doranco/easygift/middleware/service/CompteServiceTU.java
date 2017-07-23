package fr.doranco.easygift.middleware.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import fr.doranco.easygift.middleware.dao.CompteDao;
import fr.doranco.easygift.middleware.objetmetier.compte.Compte;
import fr.doranco.easygift.middleware.objetmetier.compte.CompteInexistantException;
import fr.doranco.easygift.middleware.objetmetier.compte.CompteInvalideException;

@RunWith(MockitoJUnitRunner.class)
public class CompteServiceTU {
	
	@InjectMocks
	private CompteService compteService;
	
	@Mock
	private CompteDao compteDao;
	
	@Spy
	private Compte compte;
	
	/**
	 * Test unitaire de {@link CompteService#connecter(Compte)}
	 * 
	 * Cas nominal.
	 */
	@Test
	public void connecter_nominal() throws AddressException, CompteInvalideException, CompteInexistantException {
		
		// GIVEN
		given(compteDao.obtenir(any())).willReturn(compte);
		given(compte.getIdentifiant()).willReturn("TOTO");
		given(compte.getMotDePasse()).willReturn("titi");
		
		List date = Mockito.mock(ArrayList.class);
		
		compte.getClient();
		
		// WHEN
		compteService.connecter(compte);
		
		// THEN
		Assert.assertTrue(compte.getConnecte());
	}
	
}

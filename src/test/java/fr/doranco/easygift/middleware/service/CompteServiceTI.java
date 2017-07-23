package fr.doranco.easygift.middleware.service;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.doranco.easygift.middleware.dao.CompteDao;
import fr.doranco.easygift.middleware.objetmetier.compte.Compte;
import fr.doranco.easygift.middleware.objetmetier.compte.CompteInexistantException;
import fr.doranco.easygift.middleware.objetmetier.compte.CompteInvalideException;

@RunWith(Arquillian.class)
public class CompteServiceTI {

	@Inject
	private CompteService compteService;
	
	/*
	 * Nous créons une micro application déployable et fonctionnelle,
	 * ne contenant que le nécessaire au test de notre CompteService.
	 */
	@Deployment
	public static WebArchive creerDeploiement()  {
		
		final File[] dependancesMaven = Maven.resolver()
				.loadPomFromFile("pom.xml")
				.importRuntimeAndTestDependencies()
				.resolve()
				.withTransitivity()
				.asFile();
		
		return ShrinkWrap.create(WebArchive.class)
			// Nous ajoutons toutes les classes des packages compte et client
			.addPackages(true, "fr.doranco.easygift.middleware.objetmetier.compte")
			.addPackages(true, "fr.doranco.easygift.middleware.objetmetier.client")
			// Nous ajoutons les classes de service et dao
			.addClasses(CompteService.class, CompteDao.class)
			// Nous ajoutons un beans.xml vide
			.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
			// Nous ajoutons nos dépendances Maven
			.addAsLibraries(dependancesMaven);
	}
	
	@Test
	public void connecter_nominal()
			throws CompteInvalideException, CompteInexistantException {

		// GIVEN
		final Compte compteToto = new Compte(null, "TOTO", "TOTO");
		
		// WHEN
		compteService.connecter(compteToto);
	
		// THEN
		Assert.assertTrue(compteToto.getConnecte());
	}
	
}

package fr.doranco.easygift.middleware.service;

import java.io.File;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.doranco.easygift.middleware.dao.EvaluationDao;
import fr.doranco.easygift.middleware.objetmetier.suggestion.Evaluation;

@RunWith(Arquillian.class)
public class EvaluationDaoTI {
	
	@EJB
	private EvaluationDao dao;
	
	@Deployment
	public static WebArchive creerDeployable() {
		
		final File[] dependancesMaven = Maven.resolver()
				.loadPomFromFile("pom.xml")
				.importRuntimeAndTestDependencies()
				.resolve()
				.withTransitivity()
				.asFile();
		
		return ShrinkWrap.create(WebArchive.class)
			.addClasses(EvaluationDao.class, EvaluationDaoTI.class)
			.addPackages(true, "fr.doranco.easygift.middleware.objetmetier")
			.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
			.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
			.addAsLibraries(dependancesMaven);
	}
	
	@Test
	public void test_ajouter() {
		
		// GIVEN
		final Evaluation evaluation = new Evaluation(null, null , 5);
		
		// WHEN
		dao.ajouterEvaluation(evaluation);
		
		// THEN
		// ??
	}

}

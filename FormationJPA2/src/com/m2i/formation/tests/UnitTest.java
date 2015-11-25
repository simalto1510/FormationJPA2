package com.m2i.formation.tests;

import static org.junit.Assert.*;

import java.util.*;

import javax.persistence.*;

import org.junit.Test;

import com.m2i.formation.media.entities.Media;
import com.m2i.formation.media.repositories.SingletonEMF;

public class UnitTest {

/*	@Test
	public void entityManagerTest() {
		//This test is too slow
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FormationJPA2");
		assertNotNull(emf);
		//This test is too fast
		EntityManager em = emf.createEntityManager();
		assertNotNull(em);
	}
	
	@Test
	public void IEntityTest(){

		EntityManagerFactory emf = SingletonEMF.getInstance();
		assertNotNull(emf);

		EntityManager em = emf.createEntityManager();
		assertNotNull(em);
		
		Media m = em.find(Media.class,2);
		//Verifier si m est different de null
		assertNotNull(m);
		
		String nameExpected = "Les robots";
		//Verifier si les titres sont identiques
		assertEquals(nameExpected,m.getTitle());
		System.out.println(m.getTitle());
		
	}*/
	@Test
	public void addMediaTest() {
		EntityManagerFactory emf = SingletonEMF.getInstance();
		EntityManager em = emf.createEntityManager();
		
		//1.2Compter le nombre de media
		TypedQuery tq = (TypedQuery)em.createQuery("select count(m) from Media m");
		long nbMedia = (long)tq.getSingleResult();
		assertEquals(6, nbMedia); // IL faut modifier 6 par 6 + 1 car on inser à chaque
								  //à compilation du test
		
		//IL FAUT CREER UNE METHODE TEST POUR CHAQUE QUESTION
		/*
		//1.3.2.Ouvrir et definir la transaction
		EntityTransaction tx = em.getTransaction();
		
		//1.3.3.Commencer transaction
		tx.begin();
		
		//1.3.Inserer Média
		//1.3.1.definition medi à inserer
		Media m = new Media();
		m.setCategory(1);
		m.setId_Publisher(2);
		m.setLangue("francais");
		m.setNbPages(200);
		m.setNumISBN(112);
		m.setPrice(20);
		m.setTitle("La vie est dure");
		
		//1.3.4. Inserer le media grace à la methode persist
		em.persist(m);
		tx.commit();
		
		//1.3.5. Nouveau comptage de la base
		TypedQuery tqnew = (TypedQuery)em.createQuery("select count(m) from Media m");
		long nbMedianew = (long)tqnew.getSingleResult();
		assertEquals(nbMedia + 1, nbMedianew);
		
		//1.3.6. Modification du media
		//recupération du media à update
		Media m1 = em.find(Media.class,9);
		m1.setTitle("The beauty is numero UNO");
		m1.setLangue("Espagnole");
		//Update media
		tx.begin();
		em.persist(m1);
		tx.commit();
		
		Media m2 = em.find(Media.class,9);
		String nameExpected = "The beauty is numero UNO";
		//Verifier si les titres sont identiques
		assertEquals(nameExpected,m2.getTitle());
		
		//1.3.7. Nouveau comptage de la base
		TypedQuery tqN = (TypedQuery)em.createQuery("select count(m) from Media m where m.price < 10");
		long nbMed = (long)tqN.getSingleResult();
		assertEquals(6, nbMed);
		
		//1.3.8. Suppression de tous les media ajoutés
		tx.begin();
		em.remove(m);
		em.remove(m1);
		tx.commit(); */
		
	}

}

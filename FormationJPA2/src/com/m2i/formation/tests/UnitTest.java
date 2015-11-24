package com.m2i.formation.tests;

import static org.junit.Assert.*;

import javax.persistence.*;

import org.junit.Test;

import com.m2i.formation.meida.entities.Media;

public class UnitTest {

/*	@Test
	public void entityManagerTest() {
		//This test is too slow
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FormationJPA2");
		assertNotNull(emf);
		//This test is too fast
		EntityManager em = emf.createEntityManager();
		assertNotNull(em);
	}*/
	
	@Test
	public void IEntityTest(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FormationJPA2");
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
		
	}
	

}

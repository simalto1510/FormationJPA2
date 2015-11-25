package com.m2i.formation.media.repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonEMF {

	private static EntityManagerFactory emf = null;
	
	private SingletonEMF(){
			
		}
		
	public static EntityManagerFactory getInstance(){
		
		if(emf == null){
			emf = Persistence.createEntityManagerFactory("FormationJPA2");
		}
		return emf;
	}
	
	//Ce constructeur c'est pour dire que
	//Personne peut le créer
	
}

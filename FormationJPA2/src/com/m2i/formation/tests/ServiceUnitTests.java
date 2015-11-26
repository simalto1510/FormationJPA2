package com.m2i.formation.tests;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;

import com.m2i.formation.media.entities.*;
import com.m2i.formation.media.repositories.SingletonEMF;
import com.m2i.formation.media.services.MainService;
import com.m2i.formation.media.services.ServiceException;

public class ServiceUnitTests {

	//Ce test est pour obliger le test à effectuer un cas fail 
	//Dans la methode Addauthor
	/*@Test(expected=ServiceException.class)
	public void AddAuthorToMediaTestFail() throws ServiceException {
		Author aToAdd = new Author();
		aToAdd.setName("Tom");
		aToAdd.setSurName("Cruise");
		
		MainService mS = new MainService();
		 
		int IdMediaNotExisted = 20;
		 
		 mS.addAuthorToMedia(aToAdd,IdMediaNotExisted );
		
	}*/
	
	@Test()
	public void AddAuthorToMediaTest() throws ServiceException {
		Author aToAdd = new Author();
		aToAdd.setName("Sophie");
		aToAdd.setSurName("Marceaux");
		
		MainService mS = new MainService();
		
		int IdMediaExisted = 8;
		
		mS.addAuthorToMedia(aToAdd,IdMediaExisted);
		
	}

}

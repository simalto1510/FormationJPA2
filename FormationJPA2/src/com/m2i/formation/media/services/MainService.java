package com.m2i.formation.media.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import com.m2i.formation.media.entities.*;
import com.m2i.formation.media.repositories.*;

@SuppressWarnings("unused")
public class MainService implements IMainService {

	private Media2Repository mediaRepository;
	private AuthorRepository authorRepository;
	
	/* (non-Javadoc)
	 * @see com.m2i.formation.media.services.IMainService#addAuthorToMedia(com.m2i.formation.media.entities.Author, int)
	 */
	@Override
	public void addAuthorToMedia(Author a, int mediaId) throws ServiceException{
		EntityManagerFactory emf = SingletonEMF.getInstance();
		EntityManager em = emf.createEntityManager();
		mediaRepository = new Media2Repository();
		mediaRepository.setEntityManager(em);
		
		//Media recuperé dans la BDD
		Media m = mediaRepository.getById(mediaId);
		
		//Traitement du workflow
		if(m != null){
			if(!m.getAuthors().contains(a)){ //On verifie si un auteur existe dans le media
				m.getAuthors().add(a);
				mediaRepository.getTransaction();
				mediaRepository.save(m);
				mediaRepository.commit();
			}
			else{
				throw new ServiceException("Author already associate with media");
			}
		}
		else{
			
			throw new ServiceException("The media does not exist");
		}
	}

}

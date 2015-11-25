package com.m2i.formation.media.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.m2i.formation.media.entities.Media;

public abstract class MediaRepository implements IRepository<Media>, IUoW {

	
	private EntityTransaction transaction;
	private EntityManager entityManager;
	
	public void setTransaction(EntityTransaction transaction) {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
		
	}
	
	@Override
	public void commit() {
		getTransaction().commit();
	}

	@Override
	public EntityTransaction getTransaction() {
		return transaction;
	}


	@Override
	public Media save(Media entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public Media update(Media entity) {
		return getEntityManager().merge(entity);
	}
	
	@Override
	public void remove(Media entity) {
		getEntityManager().remove(getEntityManager().merge(entity));	
	}
	
	@Override
	public Media getById(int id) {
		return getEntityManager().find(Media.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Media> getAll() {
		Query query = getEntityManager().createQuery("select e from Media e");
		List<Media> l = (List<Media>)query.getResultList();
		return  l;
	}
	
	
	

}

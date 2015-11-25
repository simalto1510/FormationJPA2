package com.m2i.formation.media.repositories;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

//import org.jboss.jandex.ParameterizedType;
//import org.hibernate.usertype.ParameterizedType;
import java.lang.reflect.ParameterizedType;

import com.m2i.formation.media.entities.IEntity;

public abstract class AbstractRepository<T extends IEntity> implements IRepository<T>, IUoW {

	@PersistenceContext
	private EntityManager entityManager;
	private EntityTransaction transaction;
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public AbstractRepository() {
		ParameterizedType genericSuperclass = (ParameterizedType)getClass().getGenericSuperclass();
		this.entityClass = (Class<T>)genericSuperclass.getActualTypeArguments()[0];
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
	public EntityTransaction getTransaction() {
		if(transaction == null){
			transaction = entityManager.getTransaction();
		}
		if(!transaction.isActive()){
			transaction.begin();
		}
		return transaction;
	}
	
	@Override
	public T save(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		return entityManager.merge(entity);
	}
	
	@Override
	public void remove(T entity) {
		entityManager.remove(entityManager.merge(entity));	
	}
	
	@Override
	public T getById(int id) {
		return entityManager.find(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return entityManager.createQuery("select e from " + entityClass.getSimpleName() +" e").getResultList();
	}
	
	
	@Override
	public void commit() {
		getTransaction().commit();
	
	}
	
	

	@Override
	public void setTransaction(EntityTransaction transaction) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<T> getByWhere(String where) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

package com.m2i.formation.media.repositories;

import java.util.List;

import com.m2i.formation.media.entities.IEntity;

public interface IRepository <T extends IEntity>{

	T save(T entity);
	
	T update(T entity);
	
	void remove(T entity);
	
	T getById(int id);
	
	List<T> getAll();
	
	List<T> getByWhere(String where);
}

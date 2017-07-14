package com.java.dao.idao;

import java.util.List;

public interface IBaseDao<T , K> {
	void save(T newT)throws Exception;
	void update(T newT)throws Exception;
	void delete(T newT)throws Exception;
	T findById(K k)throws Exception;
	List<T> findAll()throws Exception;
	

}

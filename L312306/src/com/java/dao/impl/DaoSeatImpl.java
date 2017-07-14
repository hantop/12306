package com.java.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.java.dao.idao.ISeatDao;

import hibernate.Seat;
@SuppressWarnings("unchecked")
@Repository("seatDao")
public class DaoSeatImpl implements ISeatDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(Seat t) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
	}
	
	@Override
	public void delete(Seat t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);

	}

	@Override
	public void update(Seat newT) throws Exception {
		sessionFactory.getCurrentSession().update(newT);

	}

	@Override
	public List<Seat> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("From Seat").list();
	}

	@Override
	public Seat findById(Integer k) throws Exception {
		Session session = sessionFactory.openSession();
		Seat entity = (Seat) session.get(Seat.class, k);
		session.close();
		return entity;
	}
	
	@Override
	public List<Seat> findByProperty(String propName, Object propVal) throws Exception{
		Session session = sessionFactory.openSession();
		List<Seat> seatList = session.createQuery("from Seat d where d." + propName + "=?")
				.setParameter(0, propVal)
				.list();
		session.close();
		return seatList;
	}

}

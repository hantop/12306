package com.java.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.java.dao.idao.IStationDao;

import hibernate.Station;
import hibernate.Train;
@SuppressWarnings("unchecked")
@Repository("stationDao")
public class DaoStationImpl implements IStationDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(Station t) throws Exception {
		sessionFactory.getCurrentSession().save(t);

	}

	@Override
	public void delete(Station t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);

	}

	@Override
	public void update(Station newT) throws Exception {
		sessionFactory.getCurrentSession().update(newT);

	}

	@Override
	public List<Station> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("From Station").list();
	}

	@Override
	public Station findById(String k) throws Exception {
		Session session = sessionFactory.openSession();
		Station entity = (Station) session.get(Station.class, k);
		session.close();
		return entity;
	}

	@Override
	public List<Station> findByProperty(String propName, Object propVal) throws Exception{
		Session session = sessionFactory.openSession();
			List<Station> stationList = session.createQuery("from Station d where d." + propName + "= ?")
					.setParameter(0, propVal)
					.list();
			session.close();
			return stationList;
		
	}

}

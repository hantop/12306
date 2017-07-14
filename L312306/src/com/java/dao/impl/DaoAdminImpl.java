package com.java.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.java.dao.idao.IAdminDao;

import hibernate.Admin;



@Repository("adminDao")
public class DaoAdminImpl implements IAdminDao {
	
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	@Override
	public void save(Admin t) throws Exception {
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void update(Admin newT) throws Exception {
		sessionFactory.getCurrentSession().update(newT);
	}
	
	@Override
	public void delete(Admin t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);
		
	}

	@Override
	public List<Admin> findAll() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Admin> adminList = session.createQuery("from Admin").list();
		session.clear();
		return adminList;
	}


	@Override
	public List<Admin> findByName(String name) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Admin> adminList = session.createQuery("from Admin d where d.username like ?")
				.setParameter(0, "%"+name+"%").list();
		 session.clear();
		return adminList;
	}

	@Override
	public Admin findById(Integer k) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Admin admin = (Admin) session.get(Admin.class, k);
		 session.clear();
		return admin;
	}

	@Override
	public Admin login(Admin admin2) throws Exception {
		List<Admin>  admin =  sessionFactory.getCurrentSession().createQuery("from Admin a where a.username=? and a.password=?").setParameter(0, admin2.getUsername()).setParameter(1, admin2.getPassword()).list();
		
		return admin.get(0);
	}

}

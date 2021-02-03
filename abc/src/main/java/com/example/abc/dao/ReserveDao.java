package com.example.abc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
@Component("reserveDao")
public class ReserveDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}
	
	
	
	@Transactional
	public void reserve(Reserve reserve) {
		session().save(reserve);
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserve> getReserve(String username) {
		Criteria crit = session().createCriteria(Reserve.class);

		crit.add(Restrictions.eq("user.username", username));

		return crit.list();
	}

}

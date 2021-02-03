package com.example.abc.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("busDao")
public class BusDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void create(Bus bus) {
		session().save(bus);
	}
	
	

	@SuppressWarnings("unchecked")
	public List<Bus> getAllUsers() {
		return session().createQuery("from Bus").list();
	}

	@SuppressWarnings("unchecked")
	public List<Bus> getCity(String leaveFrom, String goingTo, Date dateLeave, Date dateReturn) {
		Query query = session()
				.createQuery("from Bus where leaveFrom=:leaveFrom and goingTo=:goingTo and dateLeave=:dateLeave "
						+ "and dateReturn=:dateReturn");
		query.setParameter("leaveFrom", leaveFrom);
		query.setParameter("goingTo", goingTo);
		query.setParameter("dateLeave", dateLeave);
		query.setParameter("dateReturn", dateReturn);

		return query.list();
	}

}
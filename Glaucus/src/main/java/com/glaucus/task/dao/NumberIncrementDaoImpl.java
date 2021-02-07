package com.glaucus.task.dao;

/**
 * A DAOimpl class to create connection and write to the database.
 */
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.glaucus.task.entity.NumberIncrement;

@Component
public class NumberIncrementDaoImpl implements NumberIncrementDao {

	@Autowired
	SessionFactory sessionFaactory;

	@Autowired
	NumberIncrementDao numberIncrementDao;
 
	@Override
	public int numIncrement() {

		Session session = sessionFaactory.getCurrentSession();
		int finalNum = 0;
		try {
			session.beginTransaction();
			
			NumberIncrement numInc = (NumberIncrement) session.get(NumberIncrement.class, 1,LockOptions.UPGRADE);		
			numInc.setNumber(numInc.getNumber() + 1);
			numInc = (NumberIncrement) session.merge(numInc);
			finalNum = numInc.getNumber();
			
			session.getTransaction().commit();
		} catch (org.hibernate.StaleObjectStateException e) {
			 session.getTransaction().rollback();
			throw e;
		}
		catch (Exception e) {
			throw e;
		} 
		return finalNum;
	}
}
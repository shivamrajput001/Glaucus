package com.glaucus.task.service;

import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glaucus.task.dao.NumberIncrementDao;

/**
 * A serviceImpl class to implement business logic
 */
@Service
public class NumberIncrementServiceImpl implements NumberIncrementService {

	@Autowired
	NumberIncrementDao numberIncrementDao;

	public int incrementNumber() {
		int result = 0;
		try {
			result=	numberIncrementDao.numIncrement();
		}catch (StaleObjectStateException e) {
			throw e;
		}catch (Exception e) {
			throw e;
		}
		return result;
	}
}
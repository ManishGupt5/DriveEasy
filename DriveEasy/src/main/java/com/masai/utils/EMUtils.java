package com.masai.utils;

import com.masai.exception.CustomException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMUtils {

	static EntityManagerFactory emf = null;
	static {
		emf = Persistence.createEntityManagerFactory("HibernateProject");
	}

	public static EntityManager getEntityManager() throws CustomException {
		if(emf==null) {
			throw new CustomException("Persistence data not found");
		}
		return emf.createEntityManager();
	}
}

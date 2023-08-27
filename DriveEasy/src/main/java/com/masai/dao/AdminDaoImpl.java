package com.masai.dao;

import java.util.List;

import com.masai.entity.Admin;
import com.masai.entity.Car;
import com.masai.entity.TransactionHistory;
import com.masai.exception.CustomException;
import com.masai.utils.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class AdminDaoImpl implements AdminDao {
	private static boolean login = false;

	@Override
	public void login(String username, String password) throws CustomException {
		try (EntityManager em = EMUtils.getEntityManager()) {
			Query query = em.createQuery("Select a from Admin a where a.username=:username AND a.password=:password",
					Admin.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			Admin admin = (Admin) query.getSingleResult();
			login = true;
			System.out.println(admin);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Admin not found ,Error:" + e.getMessage());
		}

	}

	@Override
	public void addCar(Car car) throws CustomException {
		EntityTransaction emt = null;
		try (EntityManager em = EMUtils.getEntityManager()) {
			emt = em.getTransaction();
			emt.begin();
			em.persist(car);
			emt.commit();
			System.out.println("New Car Added successfuly");
		} catch (Exception e) {
			emt.rollback();
			throw new CustomException("New Car not added ,Reason:" + e.getMessage());
		}

	}

	@Override
	public void updateCar(Car car) throws CustomException {
		EntityTransaction emt = null;
		try (EntityManager em = EMUtils.getEntityManager()) {
			emt = em.getTransaction();
			emt.begin();
			em.merge(car);
			emt.commit();
			System.out.println("Car updated successfuly");
		} catch (Exception e) {
			emt.rollback();
			throw new CustomException("Car not updated ,Reason:" + e.getMessage());
		}
	}

	@Override
	public void deleteCar(int car_id) throws CustomException {
		EntityTransaction emt = null;
		try (EntityManager em = EMUtils.getEntityManager()) {
			emt = em.getTransaction();
			emt.begin();
			// we can use find method
			Query query = em.createQuery("Select c from Car c where c.car_id=:car_id", Car.class);
			query.setParameter("car_id", car_id);
			Car car = (Car) query.getSingleResult();
			car.setDeleted(true);
			em.merge(car);
			emt.commit();
			System.out.println("Car deleted successfuly");
		} catch (Exception e) {
			emt.rollback();
			throw new CustomException("Car not updated ,Reason:" + e.getMessage());
		}

	}

	@Override
	public Car getCardetails(int car_id) throws CustomException {
		try (EntityManager em = EMUtils.getEntityManager()) {
			Query query = em.createQuery("Select c from Car c where c.car_id=:car_id", Car.class);
			query.setParameter("car_id", car_id);
			return (Car) query.getSingleResult();
		} catch (Exception e) {
			throw new CustomException("Car not found ,Reason:" + e.getMessage());
		}
	}

	@Override
	public List<Car> getCarList() throws CustomException {
		try (EntityManager em = EMUtils.getEntityManager()) {
			Query query = em.createQuery("Select c from Car c", Car.class);
			return (List<Car>) query.getResultList();
		} catch (Exception e) {
			throw new CustomException("Cars not found ,Reason:" + e.getMessage());
		}
	}

	@Override
	public List<TransactionHistory> viewAllTransactions() throws CustomException {
		try (EntityManager em = EMUtils.getEntityManager()) {
			Query query = em.createQuery("Select a from TransactionHistory a", TransactionHistory.class);

			return query.getResultList();
		} catch (Exception e) {
			throw new CustomException("Transaction not found ,Reason:" + e.getMessage());
		}
	}

	@Override
	public List<TransactionHistory> viewTransactionByCarId(int car_id) throws CustomException {
		try (EntityManager em = EMUtils.getEntityManager()) {
			Query query = em.createQuery("Select a from TransactionHistory a where a.car_id=:car_id",
					TransactionHistory.class);
			query.setParameter("car_id", car_id);
			return query.getResultList();
		} catch (Exception e) {
			throw new CustomException("Transaction not found ,Reason:" + e.getMessage());
		}
	}

	@Override
	public void changeActiveStatus(int car_id) throws CustomException {
		EntityTransaction emt = null;
		try (EntityManager em = EMUtils.getEntityManager()) {
			Car car = em.find(Car.class, car_id);
			emt = em.getTransaction();
			emt.begin();
			car.setDeleted(true);
			em.merge(car);
			emt.commit();
			System.out.println("Status updated");
		} catch (Exception e) {
			throw new CustomException("Cars not found ,Reason:" + e.getMessage());
		}

	}

	@Override
	public void addnewAdmin(Admin admin) throws CustomException {
		EntityTransaction emt = null;
		try (EntityManager em = EMUtils.getEntityManager()) {
			emt = em.getTransaction();
			emt.begin();
			em.persist(admin);
			emt.commit();
			System.out.println("New Admin Added successfuly");
		} catch (Exception e) {
			emt.rollback();
			throw new CustomException("Admin not added ,Reason:" + e.getMessage());
		}

	}

}

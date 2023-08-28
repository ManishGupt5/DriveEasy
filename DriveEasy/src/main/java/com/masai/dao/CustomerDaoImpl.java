package com.masai.dao;

import java.util.List;

import com.masai.entity.Car;
import com.masai.entity.Customer;
import com.masai.entity.TransactionHistory;
import com.masai.exception.CustomException;
import com.masai.utils.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class CustomerDaoImpl implements CustomerDao {
	private static boolean login = false;

	public CustomerDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addnewCustomer(Customer customer) throws CustomException {
		EntityTransaction emt = null;
		try (EntityManager em = EMUtils.getEntityManager()) {
			emt = em.getTransaction();
			emt.begin();
			em.persist(customer);
			emt.commit();
			System.out.println("Customer added");
		} catch (Exception e) {
			throw new CustomException("Customers not added,Reason:" + e.getMessage());
		}
	}

	@Override
	public void customerLogin(String username, String password) throws CustomException {
		try (EntityManager em = EMUtils.getEntityManager()) {
			Query query = em.createQuery("Select c from Customer c where c.username=:username and c.password=:password",
					Customer.class);
			query.setParameter("username", username);
			query.setParameter("password", password);

			Customer find = (Customer) query.getSingleResult();

			System.out.println("Welcome, " + find.getName());
			System.out.println("Login successful");
			System.out.println(find);
		} catch (Exception e) {
			throw new CustomException("Invalid details,Login failed ,Reason:" + e.getMessage());
		}

	}

	@Override
	public void changePassword(String username, String password, String newPassword) throws CustomException {
		EntityTransaction emt = null;
		try (EntityManager em = EMUtils.getEntityManager()) {
			Query query = em.createQuery("Select c from Customer c where c.username=:username and c.password=:password",
					Customer.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			Customer customer1 = (Customer) query.getSingleResult();
			if (customer1 == null) {
				throw new CustomException("Invalid details , Customer not found");
			}
			emt = em.getTransaction();
			emt.begin();
			customer1.setPassword(newPassword);
			em.merge(customer1);
			emt.commit();
			System.out.println("Password updated");
		} catch (Exception e) {
			emt.rollback();
			throw new CustomException("Customers not found,Reason:" + e.getMessage());
		}

	}

	@Override
	public void changeEmail(String username, String password, String email) throws CustomException {
		EntityTransaction emt = null;
		try (EntityManager em = EMUtils.getEntityManager()) {
			Query query = em.createQuery("Select c from Customer c where c.username=:username and c.password=:password",
					Customer.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			Customer customer1 = (Customer) query.getSingleResult();
			if (customer1 == null) {
				throw new CustomException("Invalid details , Customer not found");
			}
			emt = em.getTransaction();
			emt.begin();
			customer1.setEmail(customer1.getEmail());
			em.merge(customer1);
			emt.commit();
			System.out.println("Customer Email updated");
		} catch (Exception e) {
			emt.rollback();
			throw new CustomException("Customers not found,Reason:" + e.getMessage());
		}

	}

	@Override
	public List<Car> viewAvailabeCar() throws CustomException {
		try (EntityManager em = EMUtils.getEntityManager()) {
			Query query = em.createQuery("Select c from Car c where c.isAvailable=true and c.isDeleted=false",
					Car.class);
			return (List<Car>) query.getResultList();
		} catch (Exception e) {
			throw new CustomException("No availabe car .Error:" + e.getMessage());
		}

	}

	@Override
	public void createTransaction(int car_id, int customer_id, double distance, double rate_per_km) {
		EntityTransaction emt = null;
		try (EntityManager em = EMUtils.getEntityManager()) {
			Query query = em.createQuery(
					"insert into TransactionHistory(car_id,customer_id,distance,rate_per_km) th values(:car_id,:customer_id,:distance,:rate_per_km)",
					TransactionHistory.class);
			query.setParameter("car_id", car_id);
			query.setParameter("customer_id", customer_id);
			query.setParameter("distance", distance);
			query.setParameter("rate_per_km", rate_per_km);
			emt = em.getTransaction();
			emt.begin();
			int row = query.executeUpdate();
			if (row == 0) {
				throw new CustomException("Invalid details , Transaction not found");
			}
			emt.commit();
			changeAvailability(car_id);
			System.out.println("Transaction successful");
		} catch (Exception e) {
			emt.rollback();
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void changeAvailability(int car_id) throws CustomException {
		EntityTransaction emt = null;
		try (EntityManager em = EMUtils.getEntityManager()) {
			Query query = em.createQuery("Select c from Car c where c.car_id=:car_id", Car.class);
			emt = em.getTransaction();
			emt.begin();
			query.setParameter("car_id", car_id);
			Car car = (Car) query.getSingleResult();
			car.setAvailable(!car.isAvailable());
			em.merge(car);
			emt.commit();
			System.out.println("Car availability updated");

		} catch (Exception e) {
			emt.rollback();
			throw new CustomException("Invaild car id, .Error:" + e.getMessage());
		}

	}

	@Override
	public List<TransactionHistory> viewTransactionHistories(int customer_id) throws CustomException {
		try (EntityManager em = EMUtils.getEntityManager()) {
			Query query = em.createQuery("Select a from TransactionHistory a where a.customer_id=:customer_id",
					TransactionHistory.class);

			query.setParameter("customer_id", customer_id);
			return query.getResultList();
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}


}

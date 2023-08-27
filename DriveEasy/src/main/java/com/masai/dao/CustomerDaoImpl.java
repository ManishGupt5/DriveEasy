package com.masai.dao;

import java.util.List;

import com.masai.entity.Car;
import com.masai.entity.Customer;
import com.masai.entity.TransactionHistory;
import com.masai.exception.CustomException;
import com.masai.utils.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CustomerDaoImpl implements CustomerDao {
	private static boolean login = false;

	public CustomerDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addnewCustomer(Customer customer) throws CustomException {
		// Customer(String username, String password, String name, String phone_number,
		// String email) {

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
	public void customerLogin(Customer customer) throws CustomException {
		try (EntityManager em = EMUtils.getEntityManager()) {
			Customer find = em.find(Customer.class, customer.getCustomer_id());
			if (find == null) {
				throw new CustomException("Customer not login");
			}
			System.out.println("Customer added");
		} catch (Exception e) {
			throw new CustomException("Customers not login,Reason:" + e.getMessage());
		}

	}

	@Override
	public void changePassword(Customer customer) throws CustomException {
		EntityTransaction emt = null;
		try (EntityManager em = EMUtils.getEntityManager()) {
			Customer find = em.find(Customer.class, customer.getCustomer_id());
			if (find == null) {
				throw new CustomException("Customer not found");
			}
			emt = em.getTransaction();
			emt.begin();
			find.setPassword(customer.getPassword());
			em.merge(customer);
			emt.commit();
			System.out.println("Customer password updated");
		} catch (Exception e) {
			emt.rollback();
			throw new CustomException("Customers not found,Reason:" + e.getMessage());
		}

	}

	@Override
	public void changeEmail(Customer customer) throws CustomException {
		EntityTransaction emt = null;
		try (EntityManager em = EMUtils.getEntityManager()) {
			Customer find = em.find(Customer.class, customer.getCustomer_id());
			if (find == null) {
				throw new CustomException("Customer not found");
			}
			emt = em.getTransaction();
			emt.begin();
			find.setEmail(customer.getEmail());
			em.merge(customer);
			emt.commit();
			System.out.println("Customer Email updated");
		} catch (Exception e) {
			emt.rollback();
			throw new CustomException("Customers not found,Reason:" + e.getMessage());
		}

	}

	@Override
	public List<Car> viewAvailabeCar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createTransaction(int car_id, int customer_id, double distance, double rate_per_km) {
		// TODO Auto-generated method stub

	}

	@Override
	public void bookACar(Car car_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TransactionHistory> viewTransactionHistories() {
		// TODO Auto-generated method stub
		return null;
	}

}

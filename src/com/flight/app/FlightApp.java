package com.flight.app;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.flight.db.Customer;
import com.flight.db.Flight;


public class FlightApp {

	private static Scanner sc;

	public static void main(String[] args) {
		
	
	try {
		EntityManagerFactory entityManagerFactory 
		         = Persistence.createEntityManagerFactory("flightDB");
		
		
		
		EntityManager entityManager 
		          = entityManagerFactory.createEntityManager();
		
		
		EntityTransaction entityTransaction
		             = entityManager.getTransaction();
		while(true) {
		System.out.println("------FlightApp Operations-------");
		System.out.println("1. Add Customer Record");
		System.out.println("2. Display all Customer ");
		System.out.println("3. Delete an Customer Record");
		System.out.println("4. Update Customer Record");
		System.out.println("5. Add Flight Record");
		System.out.println("6. Fetch Customer by Flight");

		System.out.println("0. Exit");
		sc = new Scanner(System.in); 
		int input = sc.nextInt();
		if(input == 0 ) {
			System.out.println("Exiting.. Bye..");
			break;
		}
		switch(input) {
			case 1: 
				//System.out.println("Insert Customer OP");
				System.out.println("Add Customer Record");
				
				System.out.println("Enter Name:");
				sc.nextLine();
				String name = sc.nextLine();
				
				System.out.println("Enter Contact: ");
				String contact = sc.next();
				
				System.out.println("Enter City:");
				String city = sc.next();
//				System.out.println("enter flight ID that customer belongs to");
//				int fid = sc.nextInt();
//				//Fetch flight record by fid
//				Flight flight = entityManager.find(Flight.class, fid);
//			if(flight == null) {
//					System.out.println("flight ID invalid");
//					break;
//				}
//				else {

				/*Attach all inputs to Customer Object */
				Customer customer = new Customer();
				customer.setName(name);
				customer.setContact(contact);
				customer.setCity(city);
				entityTransaction.begin();
				entityManager.persist(customer);
				entityTransaction.commit();
				System.out.println("Customer added to DB...");
				
				break; 
			case 2: 
				System.out.println("Customer Records");
				entityTransaction.begin();
				List<Customer> list
				                 =entityManager.createQuery("select c from Customer c",Customer.class)
				                 .getResultList();
				list.stream().forEach(System.out:: println);
				entityTransaction.commit();
				
				break;
			case 3: 
				System.out.println("Customer Deletion");
				System.out.println("Enter Customer Id to delete record");
				int id =sc.nextInt();
				entityTransaction.begin();
				Customer cus = entityManager.find(Customer.class,  id);
				if(cus == null) {
					System.out.println("Customer with ID " + id + " does not exist");
				}
				else {
					entityManager.remove(cus);
					System.out.println("Customer with Id" + id + " deleted from the DB");
					
				}
				entityTransaction.commit();
				
				
				
				break;
			case 4: 
				System.out.println("Customer Updation");
				System.out.println("Enter Customer Id to update record");
				 id =sc.nextInt();
				entityTransaction.begin();
				 cus = entityManager.find(Customer.class,  id);
				if(cus == null) {
					System.out.println("Customer with ID " + id + " does not exist");
				}
				else {
					System.out.println("Customer Details \n" + cus);
					System.out.println("Enter New Values");
					System.out.println("Enter Name:");
				sc.nextLine();
				 name = sc.nextLine();
				System.out.println("Enter Contact ");
				 contact = sc.next();
				System.out.println("Enter City");
				 city = sc.next();

				/*Attach all inputs to Customer Object */
				cus.setName(name);
				cus.setContact(contact);
				cus.setCity(city);
				entityManager.persist(cus);
				entityTransaction.commit();
				System.out.println("Customer updated  to DB...");
					
				}
				
				break;
		
			case 5: 
				System.out.println("Enter Flight Data");
				System.out.println("Enter flight source");
				sc.nextLine(); 
				String source = sc.nextLine(); 
				System.out.println("Enter flight destination");
				String destination = sc.next();
				System.out.println("Enter flight departure_date ");
				int departure_date=sc.nextInt();
				System.out.println("Enter flight fare");
				double fare =sc.nextDouble();

				//attach values to flight object
				Flight f = new Flight();
				f.setSource(source);
				f.setDestination(destination);
				f.setDeparture_date(departure_date);
				f.setFare(fare);

				//save flight in db using persist
				entityTransaction.begin();
				entityManager.persist(f);
				entityTransaction.commit();
				System.out.println("flight record added in DB..");
				break;
			case 6: 
				System.out.println("Customers booked the Flight ");
				System.out.println("Enter flight id");
				int fid = sc.nextInt();
				//fetch flight using fid
				f = entityManager.find(Flight.class, fid);

				if(f == null) {
					System.out.println("Hey! flight id is invalid");
					break;
				}
				else {
					List<Customer> slist = entityManager.createQuery("select c from Customer c where c.flight.id=" + fid, Customer.class)
					.getResultList();
					System.out.println("-----------------------------------------------------------");
					slist.stream().forEach(System.out::println);
					System.out.println("-----------------------------------------------------------");
				}
					break;
			default: 
				System.out.println("Invalid Input");
				break; 
			}
		}
		}
		catch(Exception e) {
			e.printStackTrace();}
		}
	

}

	
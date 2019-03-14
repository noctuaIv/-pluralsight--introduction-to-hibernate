package com.simpleprogrammer;

import org.hibernate.Session;

public class Program {
	
	public static void main(String[] args) {
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		User user1 = new User();
		user1.setName("Tomas");
		user1.setGoal(500);
		session.save(user1);
		
		User user2 = new User();
		user2.setName("John");
		user2.setGoal(250);
		session.save(user2);
		
		session.getTransaction().commit();
		
		session.beginTransaction();
		
		User loadedUser1 = (User) session.load(User.class, 1);
		System.out.print(loadedUser1.getName() + ": ");
		System.out.println(loadedUser1.getGoal());
		
		loadedUser1.setTotal(loadedUser1.getTotal() + 50);
		
		User loadedUser2 = (User) session.load(User.class, 2);
		System.out.print(loadedUser2.getName() + ": ");
		System.out.println(loadedUser2.getGoal());
		
		loadedUser2.setTotal(loadedUser2.getTotal() + 150);
		
		session.getTransaction().commit();
		
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}

}

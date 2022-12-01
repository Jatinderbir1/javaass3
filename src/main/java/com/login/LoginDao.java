package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class LoginDao {
	public static String user;
//	public boolean validate(login loginBean) throws ClassNotFoundException {
//		boolean status = false;
//
////		Class.forName("com.mysql.cj.jdbc.Driver");
////
////		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaass3?useSSL=false", "root","1234");
////
////				// Step 2:Create a statement using connection object
////				PreparedStatement preparedStatement = connection
////						.prepareStatement("select * from user where username = ? and password = ? ")) {
////			preparedStatement.setString(1, loginBean.getUsername());
////			preparedStatement.setString(2, loginBean.getPassword());
////
////			ResultSet rs = preparedStatement.executeQuery();
////			status = rs.next();
////
////		} catch (SQLException e) {
////			printSQLException(e);
////		}
////		return status;
//		
//	}
	@SuppressWarnings("deprecation")
	public static boolean validate(String username, String password) {
		user = username;
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Login.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session s  = factory.openSession();
		Transaction tx = s.beginTransaction();
		String hql = "select l from Login l WHERE l.username = :username and l.password = :password";
		Query query = s.createQuery(hql);
		query.setParameter("username",username);
		query.setParameter("password",password);
		Login results = (Login)query.uniqueResult();
		
		if(results != null) {
			return true;
		}
		tx.commit();
		s.close();
		
		return false;
	}
	public static String getUser() {
		return user;
	}
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
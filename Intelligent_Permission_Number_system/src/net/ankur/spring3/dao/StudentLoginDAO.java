package net.ankur.spring3.dao;


import java.util.List;

import net.ankur.spring3.entity.HibernateUtil;
import net.ankur.spring3.entity.StudentLogin;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class StudentLoginDAO {

	public int saveProfCredentials(String username , String password)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Integer Id = null;
		try {
			transaction = session.beginTransaction();
			StudentLogin studentLogin = new StudentLogin();
			studentLogin.setName(username);
			studentLogin.setPassword(password);
			Id =  (Integer) session.save(studentLogin);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return Id;
	}

	@SuppressWarnings("unchecked")
	public void listRecords()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<StudentLogin> studentRecords = session.createQuery("from StudentLogin").list();

			for (StudentLogin student : studentRecords){
				System.out.println(student.getName() +"---"+ student.getPassword());
			}

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void updateRecord(int Id, String Name , String password)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			StudentLogin student = (StudentLogin) session.get(StudentLogin.class, Id);
			student.setName(Name);
			student.setPassword(password);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteRecord(int Id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			StudentLogin student = (StudentLogin) session.get(StudentLogin.class, Id);
			session.delete(student);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean findRecord(String username, String password)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean result = false;
		try {
			transaction = session.beginTransaction();
			List<StudentLogin> studentRecords = session.createCriteria(StudentLogin.class)
												.add( Restrictions.eq("name", username))
												.add( Restrictions.eq("password", password))
												.list();
			for (StudentLogin student : studentRecords){
				if((username.equals(student.getName())) && (password.equals(student.getPassword())))
				{
					result = true;
					break;
				}
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public boolean insertRecord(String username, String password)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean result = false;
		try {
			transaction = session.beginTransaction();
			StudentLogin studentLogin = new StudentLogin();
			studentLogin.setName(username);
			studentLogin.setPassword(password);
			session.save(studentLogin);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
}

package net.ankur.spring3.dao;


import java.util.List;

import net.ankur.spring3.entity.HibernateUtil;
import net.ankur.spring3.entity.professorLogin;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ProfessorLoginDAO {

	public int saveProfCredentials(String username , String password)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Integer Id = null;
		try {
			transaction = session.beginTransaction();
			professorLogin professorLogin = new professorLogin();
			professorLogin.setName(username);
			professorLogin.setPassword(password);
			Id =  (Integer) session.save(professorLogin);
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
			List<professorLogin> profRecords = session.createQuery("from professorLogin").list();

			for (professorLogin prof : profRecords){
				System.out.println(prof.getName() +"---"+ prof.getPassword());
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
			professorLogin prof = (professorLogin) session.get(professorLogin.class, Id);
			prof.setName(Name);
			prof.setPassword(password);
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
			professorLogin prof = (professorLogin) session.get(professorLogin.class, Id);
			session.delete(prof);
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
			List<professorLogin> profRecords = session.createCriteria(professorLogin.class)
												.add( Restrictions.eq("name", username))
												.add( Restrictions.eq("password", password))
												.list();
			for (professorLogin prof : profRecords){
				if((username.equals(prof.getName())) && (password.equals(prof.getPassword())))
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
			professorLogin professorLogin = new professorLogin();
			professorLogin.setName(username);
			professorLogin.setPassword(password);
			session.save(professorLogin);
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
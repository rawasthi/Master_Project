package net.ankur.spring3.dao;

import java.util.Date;
import java.util.List;

import net.ankur.spring3.entity.AddCodeInfo;
import net.ankur.spring3.entity.HibernateUtil;
import net.ankur.spring3.entity.professorLogin;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class AddCodeInfoDAO {

	public void saveAddCodeInfo(String courseNo , String courseName , int courseSection , String waitlistName , String waitlistId , String addcode , String addCodeStatus )
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			AddCodeInfo addcodeInfo = new AddCodeInfo();
			addcodeInfo.setCourse_no(courseNo);
			addcodeInfo.setCourse_name(courseName);
			addcodeInfo.setCourse_section(courseSection);
			addcodeInfo.setWaitlist_name(waitlistName);
			addcodeInfo.setWaitlist_id(waitlistId);
			addcodeInfo.setAddcode(addcode);
			addcodeInfo.setAddcode_status(addCodeStatus);
			session.save(addcodeInfo);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	
}

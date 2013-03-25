package net.ankur.spring3.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.ankur.spring3.entity.AddCodeInfo;
import net.ankur.spring3.entity.Course;
import net.ankur.spring3.entity.HibernateUtil;
import net.ankur.spring3.entity.SectionInfo;
import net.ankur.spring3.entity.professorLogin;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class SectionInfoDAO {

	public void saveSectionInfo(String courseNo , String courseName , int courseSection , String waitlistName , String waitlistId , String enrolledName , String enrolledId )
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			SectionInfo sectionInfo = new SectionInfo();
			sectionInfo.setCourse_no(courseNo);
			sectionInfo.setCourse_name(courseName);
			sectionInfo.setCourse_section(courseSection);
			sectionInfo.setWaitlist_name(waitlistName);
			sectionInfo.setWaitlist_id(waitlistId);
			sectionInfo.setEnrolled_name(enrolledName);
			sectionInfo.setEnrolled_id(enrolledId);
			session.save(sectionInfo);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	
@SuppressWarnings("unchecked")
public ArrayList<SectionInfo> getStudentList(String courseNo, String sectionNo,  String category){
		
		
		ArrayList<SectionInfo> finalReturn = new ArrayList<SectionInfo>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		
		try {
			transaction = session.beginTransaction();
		
			
			Query q = (Query) session.createQuery("from SectionInfo as secInfo where secInfo.course_no = :courseNumber and secInfo.course_section = :sectionNo and secInfo.student_status = :status").setString("courseNumber", courseNo);
			q.setString("sectionNo", sectionNo);
			q.setString("status", category);
			//List<SectionInfo> sectionInfoReturn = q.list();
			finalReturn = (ArrayList<SectionInfo>) q.list();
			System.out.println("Total students-----------: " + finalReturn.size());
			
			for (SectionInfo temp : finalReturn){
				
				 //if(temp.getEnrolled_name()!=null){
					 //finalReturn.add(temp);
				
					 System.out.println("StudentName*** :"+temp.getEnrolled_name());
					 
				// }			
				
				}		
			
			/*if(category.equals("enrolled")){
				for (SectionInfo temp : sectionInfoReturn){
				
				 if(temp.getEnrolled_name()!=null){
					 finalReturn.add(temp);
				
					 System.out.println("StudentName*** :"+temp.getEnrolled_name());
					 
				 }			
				
				}			
			}
			else if(category.equals("waiting")){
				for (SectionInfo temp : sectionInfoReturn){
					
					 if(temp.getWaitlist_name()!=null){
						 finalReturn.add(temp);
					 
					 }			
					System.out.println("StudentName*** :"+temp.getEnrolled_name());
					}			
				}*/
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return finalReturn;
		
		
		
	}
	
	
	
	
	
}

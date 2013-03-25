package net.ankur.spring3.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.ankur.spring3.entity.Course;
import net.ankur.spring3.entity.HibernateUtil;
import net.ankur.spring3.entity.professorLogin;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CourseDAO {

	
	public int saveCourseInfo(String course_no , String course_name, int course_section, String course_time, String course_type, String course_days, String course_venue, String course_professor)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Integer Id = null;
		try {
			transaction = session.beginTransaction();
			Course course = new Course();
			course.setCourse_no(course_no);
			course.setCourse_name(course_name);
			course.setCourse_type(course_type);
			course.setCourse_section(course_section);
			course.setCourse_time(course_time);
			course.setCourse_days(course_days);
			course.setCourse_venue(course_venue);
			course.setCourse_professor(course_professor);
			Id =  (Integer) session.save(course);
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
public ArrayList<String> fetchCourseByProfessorName(String professorName){
		
		System.out.println("******:"+professorName+":*******************");
		ArrayList<String> allCourses = new ArrayList<String>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		//boolean result = false;
		try {
			transaction = session.beginTransaction();
			//List<Course> course = session.createCriteria(Course.class).add( Restrictions.eq("course_professor", professorName)).list();
			
			List<Course> course = session.createQuery("from Course as course where course.course_professor like :name").setString("name", "%"+professorName+"%").list();
			
			
			System.out.println("TotalCourses-----------: " + course.size());
			
			
			for (Course tempCourse : course){
				//if(professorName.equals(tempCourse.getCourse_professor()))
				//{
					/*result = true;
					break;*/
					System.out.println("COurseName*** :"+tempCourse.getCourse_no());
					
					allCourses.add(tempCourse.getCourse_no());
					
				//}
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return allCourses;
		
		
		
	}
	
	
	

	
}

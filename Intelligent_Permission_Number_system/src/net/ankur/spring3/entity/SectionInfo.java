package net.ankur.spring3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="section_info")
public class SectionInfo {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="course_no", nullable=false)
	private String course_no;
	
	@Column(name="course_name", nullable=false)
	private String course_name;
	
	@Column(name="course_section", nullable=false)
	private int course_section;
	
	@Column(name="enrolled_name", nullable=false)
	private String enrolled_name;
	
	@Column(name="enrolled_id", nullable=false)
	private String enrolled_id;
	
	@Column(name="waitlist_name", nullable=false)
	private String waitlist_name;
	
	@Column(name="waitlist_id", nullable=false)
	private String waitlist_id;
	
	@Column(name="student_status", nullable=false)
	private String student_status;

	public String getStudent_status() {
		return student_status;
	}

	public void setStudent_status(String student_status) {
		this.student_status = student_status;
	}

	public String getCourse_no() {
		return course_no;
	}

	public void setCourse_no(String courseNo) {
		course_no = courseNo;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String courseName) {
		course_name = courseName;
	}

	public int getCourse_section() {
		return course_section;
	}

	public void setCourse_section(int courseSection) {
		course_section = courseSection;
	}

	public String getEnrolled_name() {
		return enrolled_name;
	}

	public void setEnrolled_name(String enrolledName) {
		enrolled_name = enrolledName;
	}

	public String getEnrolled_id() {
		return enrolled_id;
	}

	public void setEnrolled_id(String enrolledId) {
		enrolled_id = enrolledId;
	}

	public String getWaitlist_name() {
		return waitlist_name;
	}

	public void setWaitlist_name(String waitlistName) {
		waitlist_name = waitlistName;
	}

	public String getWaitlist_id() {
		return waitlist_id;
	}

	public void setWaitlist_id(String waitlistId) {
		waitlist_id = waitlistId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

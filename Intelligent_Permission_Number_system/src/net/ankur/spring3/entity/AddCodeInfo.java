package net.ankur.spring3.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="addcode_info")
public class AddCodeInfo {

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
	
	@Column(name="waitlist_name", nullable=false)
	private String waitlist_name;
	
	@Column(name="waitlist_id", nullable=false)
	private String waitlist_id;
	
	@Column(name="addcode", nullable=false)
	private String addcode;
	
	@Column(name="addcode_status", nullable=false)
	private String addcode_status;
	
	@Column(name="release_time", nullable=false)
	private Date release_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAddcode() {
		return addcode;
	}

	public void setAddcode(String addcode) {
		this.addcode = addcode;
	}

	public String getAddcode_status() {
		return addcode_status;
	}

	public void setAddcode_status(String addcodeStatus) {
		addcode_status = addcodeStatus;
	}

	public Date getRelease_time() {
		return release_time;
	}

	public void setRelease_time(Date releaseTime) {
		release_time = releaseTime;
	}
}

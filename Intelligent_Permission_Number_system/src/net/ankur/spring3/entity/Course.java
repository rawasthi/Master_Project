package net.ankur.spring3.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_info")
public class Course {

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
		
		@Column(name="course_time", nullable=false)
		private String course_time;
		
		@Column(name="course_type", nullable=false)
		private String course_type;
		
		@Column(name="course_days", nullable=false)
		private String course_days;
		
		@Column(name="course_venue", nullable=false)
		private String course_venue;

		@Column(name="course_professor", nullable=false)
		private String course_professor;

		public Course() {}

		public String getCourse_venue() {
			return course_venue;
		}

		public void setCourse_venue(String course_venue) {
			this.course_venue = course_venue;
		}

		public int getId() {
			return id;
		}

		public String getCourse_no() {
			return course_no;
		}

		public void setCourse_no(String course_no) {
			this.course_no = course_no;
		}

		public String getCourse_name() {
			return course_name;
		}

		public void setCourse_name(String course_name) {
			this.course_name = course_name;
		}

		public int getCourse_section() {
			return course_section;
		}

		public void setCourse_section(int course_section2) {
			this.course_section = course_section2;
		}

		public String getCourse_time() {
			return course_time;
		}

		public void setCourse_time(String course_time) {
			this.course_time = course_time;
		}

		public String getCourse_type() {
			return course_type;
		}

		public void setCourse_type(String course_type) {
			this.course_type = course_type;
		}

		public String getCourse_days() {
			return course_days;
		}

		public void setCourse_days(String course_days) {
			this.course_days = course_days;
		}

		public String getCourse_professor() {
			return course_professor;
		}

		public void setCourse_professor(String course_professor) {
			this.course_professor = course_professor;
		}

		public void setId(int id) {
			this.id = id;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package net.ankur.spring3.form;

import java.util.ArrayList;
import java.util.List;

public class SelectCourse {
	private List<String> course;
	
	public void selectCourse(){
		this.course = new ArrayList<String>();
	}

	public List<String> getCourse() {
		return course;
	}

	public void setCourse(List<String> course) {
		this.course = course;
	}
	
}
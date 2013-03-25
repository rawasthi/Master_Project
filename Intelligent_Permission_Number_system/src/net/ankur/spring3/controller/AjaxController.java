package net.ankur.spring3.controller;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.ankur.spring3.dao.SectionInfoDAO;
import net.ankur.spring3.entity.SectionInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class AjaxController {
 
	@RequestMapping(value = "/time" , method = RequestMethod.GET)
	  public @ResponseBody String getTime(@RequestParam String name) {
	    String result = "Time for ankur is " + new Date().toString();
	    return result;
	  }
	
	/*@RequestMapping(value = "/time" , method = RequestMethod.GET)
	  public @ResponseBody String getStudentList(@RequestParam String courseNo, String status) {
	    //String result = "Time for ankur is " + new Date().toString();
	    return result;
	  }*/
	
	@RequestMapping(value = "/studentList" , method = RequestMethod.GET)
	  public @ResponseBody String getStudentList(@RequestParam String courseNo, String sectionNo,  String category) {
	    //String result = "Time for ankur is " + new Date().toString();
	  //  return result;
		//Return the student list for a particular course as per category.
		
		SectionInfoDAO secInfoDAO = new SectionInfoDAO();
		
		List<SectionInfo> abc = new ArrayList<SectionInfo>();
		
		abc = secInfoDAO.getStudentList(courseNo,sectionNo,category);
		
		
		
		String result = null;
		
		
		
		
		
		
		return result;
	  }
	
	
	
}

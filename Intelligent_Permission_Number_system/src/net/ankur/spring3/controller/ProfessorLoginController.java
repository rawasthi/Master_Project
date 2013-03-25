package net.ankur.spring3.controller;

import net.ankur.spring3.dao.CourseDAO;
import net.ankur.spring3.dao.ProfessorLoginDAO;
import net.ankur.spring3.dao.SectionInfoDAO;
import net.ankur.spring3.entity.SectionInfo;
import net.ankur.spring3.form.LoginForm;
import net.ankur.spring3.form.SelectCourse;
import net.ankur.spring3.xmlparsing.CourseInfoParser;
import net.ankur.spring3.xmlparsing.ProfessorLoginParser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;


@Controller
@RequestMapping("ProfessorLogin.html")
public class ProfessorLoginController {
        @RequestMapping(method = RequestMethod.GET)
        public String showForm(ModelMap model) {
                LoginForm loginForm = new LoginForm();
                ProfessorLoginParser professorLoginParser = new ProfessorLoginParser();
                CourseInfoParser courseInfoParser = new CourseInfoParser();
                model.put("loginForm", loginForm);
                return "ProfessorLogin";
        }

        @RequestMapping(method = RequestMethod.POST)
        public String processForm(@Valid LoginForm loginForm, BindingResult result,
        		ModelMap model) {
        	
        	ProfessorLoginDAO profDAO = new ProfessorLoginDAO();
        	
                if (result.hasErrors()) {
                        return "ProfessorLogin";
                }
                loginForm = (LoginForm) model.get("loginForm");
                String username = loginForm.getUserName();
                String password = loginForm.getPassword();
 
               boolean Result =  profDAO.findRecord(username, password);
                if (!Result){
                	result.rejectValue("notValid", "error.object", "UserName and Password not valid.");
                        return "ProfessorLogin";
                }
                
                CourseDAO courseDAO = new CourseDAO();
                
                
                //Testing return studentList for enrolled students.
                SectionInfoDAO sectionInfoDAO = new SectionInfoDAO();
                
                List<SectionInfo> xyz = sectionInfoDAO.getStudentList("CMPE 030", "1", "enrolled");
                for(SectionInfo tmp : xyz){
                	
                	System.out.println(tmp.getEnrolled_name());
                }
                
                
                List<String> abc = new ArrayList<String>();
                
               abc = courseDAO.fetchCourseByProfessorName(username);
                
               System.out.println("************:"+abc+":************");
               // abc.add("a");
                //abc.add("b");
                SelectCourse selectCourse = new SelectCourse();
                selectCourse.setCourse(abc);
                model.put("selectCourse", selectCourse);
                return "ProfessorMain";
        }
        

}


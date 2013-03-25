package net.ankur.spring3.controller;

import net.ankur.spring3.dao.StudentLoginDAO;
import net.ankur.spring3.form.LoginForm;
import net.ankur.spring3.xmlparsing.StudentLoginParser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;


@Controller
@RequestMapping("StudentLogin.html")
public class StudentLoginController {
        @RequestMapping(method = RequestMethod.GET)
        public String showForm(ModelMap model) {
                LoginForm loginForm = new LoginForm();
                StudentLoginParser studentLoginParser = new StudentLoginParser();
                model.put("loginForm", loginForm);
                return "StudentLogin";
        }

        @RequestMapping(method = RequestMethod.POST)
        public String processForm(@Valid LoginForm loginForm, BindingResult result,
        		ModelMap model) {
        	
        	StudentLoginDAO studentDAO = new StudentLoginDAO();
        	
                if (result.hasErrors()) {
                        return "StudentLogin";
                }
                loginForm = (LoginForm) model.get("loginForm");
                String username = loginForm.getUserName();
                String password = loginForm.getPassword();
 
               boolean Result =  studentDAO.findRecord(username, password);
                if (!Result){
                	result.rejectValue("notValid", "error.object", "UserName and Password not valid.");
                        return "StudentLogin";
                }
                model.put("loginForm", loginForm);
                return "StudentMain";
        }
        

}


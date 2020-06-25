package com.wipro.OnlineAssessmentSystem;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.OnlineAssessmentSystem.Model.Admin;
import com.wipro.OnlineAssessmentSystem.Model.Student;
import com.wipro.OnlineAssessmentSystem.Model.Test;
import com.wipro.OnlineAssessmentSystem.Service.AdminService;
import com.wipro.OnlineAssessmentSystem.Service.StudentService;
import com.wipro.OnlineAssessmentSystem.Service.TestService;

@Controller
@EnableAutoConfiguration
public class MainController {
	@Autowired
	StudentService studentService;

	@Autowired
	AdminService adminService;

	@Autowired
	TestService testService;
	String finalEmail = "";

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	/* Student functions */
	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("Register")
	public String dataStore(Student stu, Model model) {
		model.addAttribute("stu", stu);
		int ch=studentService.saveStudent(stu);
		if (ch==1) {
			return "registerConfirm";
		} else {
			return "register";
		}
	}

	@RequestMapping("UserCheck")
	public String check(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		int a = studentService.validate(email, password);
		if (a == 0) {
			finalEmail = email;
			return "loginU";
		} else if (a == 3) {
			return "loginA";
		} else if (a == 1) {
			return "passwordErrorPage";
		} else {
			return "invalidUserPage";
		}
	}

	@RequestMapping("/springAssessment")
	public String spring() {
		return "springAssessment";
	}

	@RequestMapping(value = "/springSubmit")
	public String springSubmit(HttpServletRequest request) {
		String result = "", template = "";
		int score = studentService.springCheck(
				request.getParameter("Question1"),
				request.getParameter("Question2"),
				request.getParameter("Question3"),
				request.getParameter("Question4"),
				request.getParameter("Question5"));
		if (score >= 30) {
			result = "Passed";
			template = "successPage";
		} else {
			result = "Failed";
			template = "failurePage";
		}
		Date now = new Date();
		
		Test t = new Test();
		t.setAssessment("Spring");
		t.setEmail(finalEmail);
		t.setObtainedMarks(score);
		t.setResult(result);
		t.setTestDate(now);
		t.setTotalMarks(50);
		testService.saveStudent(t);
		return template;
	}

	@RequestMapping(value = "/hibernateSubmit")
	public String hibernateSubmit(HttpServletRequest request) {
		String result = "", template = "";
		int score = studentService.hibernateCheck(
				request.getParameter("Question1"),
				request.getParameter("Question2"),
				request.getParameter("Question3"),
				request.getParameter("Question4"),
				request.getParameter("Question5"));
		if (score >= 30) {
			result = "Passed";
			template = "successPage";
		} else {
			result = "Failed";
			template = "failurePage";
		}
		Date now = new Date();
		Test t = new Test();
		t.setAssessment("Hibernate");
		t.setEmail(finalEmail);
		t.setObtainedMarks(score);
		t.setResult(result);
		t.setTestDate(now);
		t.setTotalMarks(50);
		testService.saveStudent(t);
		return template;
	}

	@RequestMapping("/hibernateAssessment")
	public String hibernate() {
		return "hibernateAssessment";
	}

	/* Admin functions */
	@RequestMapping("/users/All")
	public String user(Model model) {
		List<Admin> allAdmin = adminService.getAllAdmin();
		List<Student> allStu = studentService.getAll();
		model.addAttribute("allAdmin", allAdmin);
		model.addAttribute("allStu", allStu);
		return "allUserDetails";
	}

	/* Test functions */
	@RequestMapping("/tests/All")
	public String test(Model model) {
		List<Test> allTest = testService.getAllTestDetails();
		model.addAttribute("allTest", allTest);
		return "allTestDetails";
	}
}

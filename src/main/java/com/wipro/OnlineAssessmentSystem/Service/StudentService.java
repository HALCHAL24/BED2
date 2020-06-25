package com.wipro.OnlineAssessmentSystem.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wipro.OnlineAssessmentSystem.Model.Admin;
import com.wipro.OnlineAssessmentSystem.Model.Student;
import com.wipro.OnlineAssessmentSystem.Repository.AdminRepository;
import com.wipro.OnlineAssessmentSystem.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	// get all student details
		public List<Student> getAll() {
		return studentRepository.findAll(Sort.by("fname"));
	}
	// save new student
	public int saveStudent(Student stu) {
		int ch=1;
		List<Student> list = new ArrayList();
		studentRepository.findAll().forEach(list::add);
		for (Student student :list) {
			if (student.getEmail().equals(stu.getEmail())) {
				ch=0;
				break;
			}
		}
		if(ch==1) { studentRepository.save(stu); }
		return ch;
	}
	// validate existing students
	public int validate(String email, String pass) {
		List<Student> Stulist = new ArrayList();
		studentRepository.findAll().forEach(Stulist::add);
		List<Admin> Adlist = new ArrayList();
		adminRepository.findAll().forEach(Adlist::add);
		int ch = 2;
		for (Student stu : Stulist) {
			if (stu.getEmail().equalsIgnoreCase(email)) {
				if (stu.getPassword().equals(pass)) {
					ch = 0;
					break;
				} else {
					ch = 1;
					break;
				}
			}
		}
		for (Admin ad : Adlist) {
			if (ad.getEmail().equalsIgnoreCase(email)) {
				if (ad.getPassword().equals(pass)) {
					ch = 3;
					break;
				} else {
					ch = 1;
					break;
				}
			}
		}
		return ch;
	}
    public int springCheck(String a,String b,String c,String d,String e)
    {
    	int score=0;
    	if(a.equals("J2EE App Development Framework"))
    	{
    		score+=10;
    	}
    	if(b.equals("Inversion Of Control"))
    	{
    		score+=10;
    	}
    	if(c.equals("Aspect Oriented Programming"))
    	{
    		score+=10;
    	}
    	if(d.equals("Application Context"))
    	{
    		score+=10;
    	}
    	if(e.equals("Dispatcher Servlet"))
    	{
    		score+=10;
    	}
    	return score;
    }
    
    public int hibernateCheck(String a,String b,String c,String d,String e)
    {
    	int score=0;
    	if(a.equals("Object Relational Mapping"))
    	{
    		score+=10;
    	}
    	if(b.equals("uni-directional & bi-directional"))
    	{
    		score+=10;
    	}
    	if(c.equals("configuration file"))
    	{
    		score+=10;
    	}
    	if(d.equals("Hibernate Query Language"))
    	{
    		score+=10;
    	}
    	if(e.equals("isolation levels"))
    	{
    		score+=10;
    	}
    	return score;
    	}
	
}



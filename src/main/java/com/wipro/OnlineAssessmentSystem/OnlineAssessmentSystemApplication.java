package com.wipro.OnlineAssessmentSystem;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.wipro.OnlineAssessmentSystem.Model.Admin;
import com.wipro.OnlineAssessmentSystem.Service.AdminService;
@SpringBootApplication
@EnableJpaRepositories(basePackages="com.wipro.OnlineAssessmentSystem.Repository")
@EntityScan(basePackages="com.wipro.OnlineAssessmentSystem.Model")
public class OnlineAssessmentSystemApplication {
	@Autowired
	AdminService adminService;
	public static void main(String[] args) {
		SpringApplication.run(OnlineAssessmentSystemApplication.class, args);	
	}
	@PostConstruct
	public void  init()
	{
		Admin a1 = new Admin("Roger","Kutcher","roger@gmail.com","wipro@123");
		Admin a2 = new Admin("Steve","Martin","steve@gmail.com","wipro@123");
		List<Admin> admin = new ArrayList<Admin>();
		admin.add(a1);
		admin.add(a2);
		adminService.saveAdmin(admin);
	}
}

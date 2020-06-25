package com.wipro.OnlineAssessmentSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wipro.OnlineAssessmentSystem.Model.Admin;
import com.wipro.OnlineAssessmentSystem.Repository.AdminRepository;
@Service
public class AdminService {
	@Autowired 
    AdminRepository adminRepository;
    
    //get all admin details
    public List<Admin> getAllAdmin()
    {
  	 return adminRepository.findAll(Sort.by("fname"));
  	
    }
    public void saveAdmin(List<Admin> ad) {
		adminRepository.saveAll(ad);
}
}

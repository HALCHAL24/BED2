package com.wipro.OnlineAssessmentSystem.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wipro.OnlineAssessmentSystem.Model.Admin;

public interface AdminRepository extends PagingAndSortingRepository<Admin,Long> {
 
	List<Admin> findAll(Sort by);  
}

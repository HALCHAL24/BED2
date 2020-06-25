package com.wipro.OnlineAssessmentSystem.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wipro.OnlineAssessmentSystem.Model.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student,String> {

	List<Student> findAll(Sort by);   
	
	
}

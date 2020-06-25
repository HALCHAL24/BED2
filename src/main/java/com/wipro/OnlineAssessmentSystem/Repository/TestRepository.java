package com.wipro.OnlineAssessmentSystem.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wipro.OnlineAssessmentSystem.Model.Test;

public interface TestRepository extends PagingAndSortingRepository<Test,Long> {
	List<Test> findAll(Sort by);  
}

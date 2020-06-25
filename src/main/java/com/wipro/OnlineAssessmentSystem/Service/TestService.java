package com.wipro.OnlineAssessmentSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wipro.OnlineAssessmentSystem.Model.Test;
import com.wipro.OnlineAssessmentSystem.Repository.TestRepository;

@Service
public class TestService {
     @Autowired 
     TestRepository testRepository;
     
     public List<Test> getAllTestDetails() 
     {
 		return testRepository.findAll(Sort.by("testDate"));
     }
     public void saveStudent(Test t) {
 		testRepository.save(t);
     
}
}

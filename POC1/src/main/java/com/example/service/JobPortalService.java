package com.example.service;

import java.util.List;


import org.springframework.web.multipart.MultipartFile;

import com.example.model.JobPortal;

public interface JobPortalService {
	public String postJobDecription(JobPortal jobPortal);

	public String getJobById(int id);

	public List<JobPortal> getJobType(String name);

	public List<JobPortal> getExperience(int exp);
	
	public List<JobPortal> getCountry(String country);
	
	public List<JobPortal> getAvailbility(String availble) ;
	
	public List<JobPortal> getSkills(String skills);
	
	public List<JobPortal> getLanguage(String language);
	
	public List<JobPortal> getPayRate(int min, int max);
	
	public List<JobPortal> getAllJobs() ;
	
	public List<JobPortal> saveAll(MultipartFile file) ;

}
	

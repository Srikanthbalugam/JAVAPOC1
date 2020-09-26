package com.example.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.component.ExcelHelper;
import com.example.model.JobPortal;
import com.example.service.JobPortalServiceImpl;

@RestController
@RequestMapping("/job")
public class JobPortalController {
    @Autowired
    private JobPortalServiceImpl jobPortalService;
    
	  private static final Logger log = Logger.getLogger(JobPortalController.class.getName());

	
    @PostMapping(value = "/postjob", produces = { "application/json", "application/xml" }, consumes = {
			"application/xml", "application/json" })
	public String postJobDecription(@RequestBody JobPortal jobPortal)
	{
    	log.info("Data posting success.........");
    	log.debug("Data posted.......");
		jobPortalService.postJobDecription(jobPortal);
		return "Succesfully Inserted";
	}
	
	@PostMapping("/processexcel")
	public List<JobPortal> uploadFile(@RequestParam("file") MultipartFile file) {
		
		System.out.println("data coming''''''''''''''''");
		log.info("Xl file Data posting success.........");
    	log.debug("Data posted.......");
		if (ExcelHelper.hasExcelFormat(file)) {

			try {
				
				
				List<JobPortal> list = jobPortalService.saveAll(file);
				return list;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ArrayList<JobPortal>();

			}
		} else {
			System.out.println("not excel format");
			return new ArrayList<>();
		}

	}
	
	@GetMapping(value="/getjob/{id}", produces = { "application/json", "application/xml" })
	public String getJobById(@PathVariable("id") int id)
	{
		log.debug("Job getting fine.......");
		return jobPortalService.getJobById(id);
	}
	@GetMapping(value="/getByType/{name}", produces = { "application/json", "application/xml" })
	public List<JobPortal> getJobType(@PathVariable("name") String name)
	{
		log.debug("JobType getting fine.......");

		return jobPortalService.getJobType(name);
	}
	
     @GetMapping(value="/getByExp/{exp}", produces = { "application/json", "application/xml" })
     public List<JobPortal> getExperience(@PathVariable("exp") int exp)
 	{
 	    return jobPortalService.getExperience(exp);
 	}
     
    @GetMapping(value="/getByCountry/{country}", produces = { "application/json", "application/xml" }) 
    public List<JobPortal> getCountry(@PathVariable("country") String country)
 	{
 	    return jobPortalService.getCountry(country);
 	}
    
    @GetMapping(value="/getByAvailability/{availble}", produces = { "application/json", "application/xml" })
    public List<JobPortal> getAvailability(@PathVariable("availble") String availble)
 	{
 	    return jobPortalService.getAvailbility(availble);
 	}
    
    @GetMapping(value="/getBySkills/{skills}", produces = { "application/json", "application/xml" })
    public List<JobPortal> getBySkills(@PathVariable("skills") String skills)
 	{
 	    return jobPortalService.getSkills(skills);
 	}
    
    @GetMapping(value="/getByLanguage/{language}", produces = { "application/json", "application/xml" })
    public List<JobPortal> getLanguage(@PathVariable("language") String language)
 	{
 	    return jobPortalService.getLanguage(language);
 	}
    
    @GetMapping(value="/getByPayRate/{min}/{max}", produces = { "application/json", "application/xml" })
    public List<JobPortal> getPayRate(@PathVariable("min") int min,@PathVariable("max") int max)
 	{
 	    return jobPortalService.getPayRate(min,max);
 	}
    
    @GetMapping(value="/getalljobs", produces = { "application/json", "application/xml" })
    public List<JobPortal> getAllJobs()
 	{
 	    return jobPortalService.getAllJobs();
 	}
    
     
}

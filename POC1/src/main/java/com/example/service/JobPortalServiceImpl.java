package com.example.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.component.ExcelHelper;
import com.example.exception.CustomException;
import com.example.model.JobPortal;
import com.example.repository.JobPortalRepository;

@Service
public class JobPortalServiceImpl implements JobPortalService{
	@Autowired
	private JobPortalRepository jobPortalRepository;

	public String postJobDecription(JobPortal jobPortal) {
		JobPortal addCustomer = jobPortalRepository.save(jobPortal);
		return "succes";
	}

	public String getJobById(int id) {
		try {
			if (id == 0) {
				throw new CustomException("pls Enter valid id");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		JobPortal findById = jobPortalRepository.findById(id);

		return findById.getJobTitle();
	}

	public List<JobPortal> getJobType(String name) {
		try {
			if (name.equals(null) || name.isEmpty()) {
				throw new CustomException("pls Enter valid name");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return jobPortalRepository.findByJobType(name);
	}

	public List<JobPortal> getExperience(int exp) {
		try {
			if (exp == 0) {
				throw new CustomException("Entered exp is invalid");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return jobPortalRepository.findByExperience(exp);
	}

	public List<JobPortal> getCountry(String country) {
		try {
			if (country.equals(null) || country.isEmpty()) {
				throw new CustomException("Contry should not be null");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return jobPortalRepository.findByCountry(country);
	}

	public List<JobPortal> getAvailbility(String availble) {
		try {
			if (availble.equals(null) || availble.isEmpty()) {
				throw new CustomException("must provide availbility");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return jobPortalRepository.findByAvailbility(availble);
	}

	public List<JobPortal> getSkills(String skills) {

		return jobPortalRepository.findBySkillsContaining(skills);
	}

	public List<JobPortal> getLanguage(String language) {

		return jobPortalRepository.findByLanguage(language);
	}

	public List<JobPortal> getPayRate(int min, int max) {
		try {
			if (min == 0 || max == 100) {
				throw new CustomException("provide proper payrates");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return jobPortalRepository.findByPayRate(min, max);
	}

	public List<JobPortal> getAllJobs() {

		return jobPortalRepository.findAll();
	}

	public List<JobPortal> saveAll(MultipartFile file) {
		try {

			List<JobPortal> jobs = ExcelHelper.excelToTutorials(file.getInputStream());

			List<JobPortal> saveAll = jobPortalRepository.saveAll(jobs);

			return saveAll;
		} catch (IOException e) {

			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

}

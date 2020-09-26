package com.example.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.model.JobPortal;

@Repository
public interface JobPortalRepository extends JpaRepository<JobPortal, Integer> {
	@Query("SELECT e FROM JobPortal e WHERE e.id = :id")
	JobPortal findById(int id);

	@Query("SELECT e FROM JobPortal e WHERE e.jobType = :name")
	List<JobPortal> findByJobType(String name);

	@Query("SELECT e FROM JobPortal e WHERE e.experience = :exp")
	List<JobPortal> findByExperience(int exp);

	@Query("SELECT e FROM JobPortal e WHERE e.country = :country")
	List<JobPortal> findByCountry(String country);

	@Query("SELECT e FROM JobPortal e WHERE e.availability = :availble")
	List<JobPortal> findByAvailbility(String availble);

	@Query("SELECT e FROM JobPortal e WHERE e.language = :language")
	List<JobPortal> findByLanguage(String language);

	@Query("SELECT e FROM JobPortal e WHERE e.payRate BETWEEN ?1 AND ?2")
	List<JobPortal> findByPayRate(int min, int max);
	
	public List<JobPortal> findBySkillsContaining(String skill);

}

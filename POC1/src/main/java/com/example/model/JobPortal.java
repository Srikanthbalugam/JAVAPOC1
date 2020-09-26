package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Required;

import lombok.Data;

@Data
@Entity
@XmlRootElement
public class JobPortal {
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "jobTitle is required")
	private String jobTitle;
	
	@NotEmpty(message = "jobDescrption is required")
	private String jobDescription;
	
	@NotEmpty(message = "country is required")
	private String country;
	
	@NotEmpty(message = "state is required")
	private String state;
	
	@NotEmpty(message = "availability is required")
	private String availability;
	
	@NotEmpty(message = "replyRate is required")
	private int replyRate;
	
	@NotEmpty(message = "payRate is required")
	private int payRate;
	
	@NotEmpty(message = "experience is required")
	private int experience;
	
	@NotEmpty(message = "skills is required")
	private String skills;
	
	@NotEmpty(message = "language is required")
	private String language;
	
	@NotEmpty(message = "jobType is required")
	private String jobType;
	
	@OneToOne(cascade = CascadeType.ALL)
	@NotEmpty(message = "user is required")
	private UserInfo userInfo;
}

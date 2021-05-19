package com.oihello.selfinfo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long personId;
	
	private String fullName;
	
	private String email;
	
	private String careerSummary;
	
	private String careerObjective;

	public Person() {
		super();
	}

	public Person(long personId) {
		super();
		this.personId = personId;
	}

	public Person(Long personId, String fullName, String email, String careerSummary, String careerObjective) {
		super();
		this.personId = personId;
		this.email = email;
		this.fullName = fullName;
		this.careerSummary = careerSummary;
		this.careerObjective = careerObjective;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCareerSummary() {
		return careerSummary;
	}

	public void setCareerSummary(String careerSummary) {
		this.careerSummary = careerSummary;
	}

	public String getCareerObjective() {
		return careerObjective;
	}

	public void setCareerObjective(String careerObjective) {
		this.careerObjective = careerObjective;
	}

	@Override
	public String toString() {
		return "Person [persionId=" + personId + ", fullName=" + fullName + ", email=" + email + ", careerSummary=" + careerSummary
				+ ", careerObjective=" + careerObjective + "]";
	}

}

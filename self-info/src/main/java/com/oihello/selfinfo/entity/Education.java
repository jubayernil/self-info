package com.oihello.selfinfo.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long educationId;
	
	private String collegeName;
	
	private String majorSubject;
	
	private Date startDate;
	
	private Date endDate;
	
	@ManyToOne
	private Person person;

	public Education() {
		super();
	}

	public Education(long educationId) {
		super();
		this.educationId = educationId;
	}

	public Education(long educationId, String collegeName, String majorSubject, Date startDate, Date endDate,
			Person person) {
		super();
		this.educationId = educationId;
		this.collegeName = collegeName;
		this.majorSubject = majorSubject;
		this.startDate = startDate;
		this.endDate = endDate;
		this.person = person;
	}

	public long getEducationId() {
		return educationId;
	}

	public void setEducationId(long educationId) {
		this.educationId = educationId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getMajorSubject() {
		return majorSubject;
	}

	public void setMajorSubject(String majorSubject) {
		this.majorSubject = majorSubject;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Education [educationId=" + educationId + ", collegeName=" + collegeName + ", majorSubject="
				+ majorSubject + ", startDate=" + startDate + ", endDate=" + endDate + ", person=" + person + "]";
	}
}

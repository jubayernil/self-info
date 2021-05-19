package com.oihello.selfinfo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class WorkExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long workId;
	
	private String companyName;
	
	private String startDate;
	
	private String endDate;
	
	private String workPosition;
	
	@ManyToOne
	private Person person;

	public WorkExperience() {
		super();
	}

	public WorkExperience(long workId) {
		super();
		this.workId = workId;
	}

	public WorkExperience(long workId, String companyName, String startDate, String endDate, String workPosition,
			long personId) {
		super();
		this.workId = workId;
		this.companyName = companyName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.workPosition = workPosition;
		this.setPerson(new Person(personId));
	}

	public long getWorkId() {
		return workId;
	}

	public void setWorkId(long workId) {
		this.workId = workId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getWorkPosition() {
		return workPosition;
	}

	public void setWorkPosition(String workPosition) {
		this.workPosition = workPosition;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "WorkExperience [workId=" + workId + ", companyName=" + companyName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", workPosition=" + workPosition + ", person=" + person + "]";
	}

	
}

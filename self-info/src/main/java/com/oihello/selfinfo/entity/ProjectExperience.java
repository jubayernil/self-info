package com.oihello.selfinfo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProjectExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectId;
	
	private String projectName;
	
	private String startDate;
	
	private String endDate;
	
	private String projectDetail;
	
	@ManyToOne
	private WorkExperience workExperience;
	
	@ManyToOne
	private Person person;

	public ProjectExperience() {
		super();
	}

	public ProjectExperience(long projectId) {
		super();
		this.projectId = projectId;
	}

	public ProjectExperience(long projectId, String projectName, String startDate, String endDate, String projectDetail,
			long workId, long personId) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectDetail = projectDetail;
		this.setWorkExperience(new WorkExperience(workId));
		this.setPerson(new Person(personId));
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public String getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(String projectDetail) {
		this.projectDetail = projectDetail;
	}

	public WorkExperience getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(WorkExperience workExperience) {
		this.workExperience = workExperience;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "ProjectExperience [projectId=" + projectId + ", projectName=" + projectName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", projectDetail=" + projectDetail + ", workExperience=" + workExperience
				+ ", person=" + person + "]";
	}
}

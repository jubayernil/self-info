package com.oihello.selfinfo.service;

import java.util.List;

import com.oihello.selfinfo.entity.WorkExperience;

public interface WorkExperienceServiceInfc {
	
	WorkExperience createWorkExperience(WorkExperience workExperience);
	
	List<WorkExperience> getAllWorkExperiences(long personId);

	WorkExperience getWorkExperienceById(long workId);

	WorkExperience updateWorkExperience(WorkExperience workExperience);

	void deleteWorkExperience(long workId);
}

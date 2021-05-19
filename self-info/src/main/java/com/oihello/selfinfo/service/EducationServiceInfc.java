package com.oihello.selfinfo.service;

import java.util.List;

import com.oihello.selfinfo.entity.Education;

public interface EducationServiceInfc {
	
	Education createEducation(Education education);
	
	List<Education> getAllEducations(long personId);

	Education getEducationById(long educationId);

	Education updateEducation(Education education);

	void deleteEducation(long educationId);
}

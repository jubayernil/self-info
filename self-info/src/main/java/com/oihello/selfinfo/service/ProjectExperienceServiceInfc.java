package com.oihello.selfinfo.service;

import java.util.List;

import com.oihello.selfinfo.entity.ProjectExperience;

public interface ProjectExperienceServiceInfc {
	
	ProjectExperience createProjectExperience(ProjectExperience projectExperience);
	
	List<ProjectExperience> getAllProjectExperiences(long personId, long workId);

	ProjectExperience getProjectExperienceById(long projectId);

	ProjectExperience updateProjectExperience(ProjectExperience projectExperience);

	void deleteProjectExperience(long projectId);
}

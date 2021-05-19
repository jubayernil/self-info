package com.oihello.selfinfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oihello.selfinfo.entity.ProjectExperience;
import com.oihello.selfinfo.exception.ResourceNotFoundException;
import com.oihello.selfinfo.repository.ProjectExperienceRepository;

@Service
@Transactional
public class ProjectExperienceServiceImpl implements ProjectExperienceServiceInfc{
	
	@Autowired
	private ProjectExperienceRepository rpository;

	@Override
	public ProjectExperience createProjectExperience(ProjectExperience projectExperience) {
		return rpository.save(projectExperience);
	}

	@Override
	public List<ProjectExperience> getAllProjectExperiences(long personId, long workId) {
		return this.rpository.findByPersonPersonIdAndWorkExperienceWorkId(personId, workId);
	}

	@Override
	public ProjectExperience getProjectExperienceById(long projectId) {
		Optional<ProjectExperience> dbData = this.rpository.findById(projectId);

		if (dbData.isPresent()) {
			return dbData.get();
		} else {
			throw new ResourceNotFoundException("Record not found with project id : " + projectId);
		}
	}

	@Override
	public ProjectExperience updateProjectExperience(ProjectExperience projectExperience) {
		Optional<ProjectExperience> dbData = this.rpository.findById(projectExperience.getProjectId());

		if (dbData.isPresent()) {
			ProjectExperience updateData = dbData.get();
			updateData.setProjectName(projectExperience.getProjectName());
			updateData.setStartDate(projectExperience.getStartDate());
			updateData.setEndDate(projectExperience.getEndDate());
			updateData.setProjectDetail(projectExperience.getProjectDetail());
			rpository.save(updateData);
			return updateData;
		} else {
			throw new ResourceNotFoundException("Record not found with project id : " + projectExperience.getProjectId());
		}
	}

	@Override
	public void deleteProjectExperience(long projectId) {
		Optional<ProjectExperience> dbData = this.rpository.findById(projectId);
		
		if(dbData.isPresent()) {
			this.rpository.delete(dbData.get());
		}else {
			throw new ResourceNotFoundException("Record not found with project id : " + projectId);
		}
	}

}

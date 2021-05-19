package com.oihello.selfinfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oihello.selfinfo.entity.WorkExperience;
import com.oihello.selfinfo.exception.ResourceNotFoundException;
import com.oihello.selfinfo.repository.WorkExperienceRepository;

@Service
@Transactional
public class WorkExperienceServiceImpl implements WorkExperienceServiceInfc{
	
	@Autowired
	private WorkExperienceRepository repository;

	@Override
	public WorkExperience createWorkExperience(WorkExperience workExperience) {
		return repository.save(workExperience);
	}

	@Override
	public List<WorkExperience> getAllWorkExperiences(long personId) {
		return this.repository.findByPersonPersonId(personId);
	}

	@Override
	public WorkExperience getWorkExperienceById(long workId) {
		Optional<WorkExperience> dbData = this.repository.findById(workId);

		if (dbData.isPresent()) {
			return dbData.get();
		} else {
			throw new ResourceNotFoundException("Record not found with work id : " + workId);
		}
	}

	@Override
	public WorkExperience updateWorkExperience(WorkExperience workExperience) {
		Optional<WorkExperience> dbData = this.repository.findById(workExperience.getWorkId());

		if (dbData.isPresent()) {
			WorkExperience updateData = dbData.get();
			updateData.setCompanyName(workExperience.getCompanyName());
			updateData.setStartDate(workExperience.getStartDate());
			updateData.setEndDate(workExperience.getEndDate());
			updateData.setWorkPosition(workExperience.getWorkPosition());
			repository.save(updateData);
			return updateData;
		} else {
			throw new ResourceNotFoundException("Record not found with work id : " + workExperience.getWorkId());
		}
	}

	@Override
	public void deleteWorkExperience(long workId) {
		Optional<WorkExperience> dbData = this.repository.findById(workId);
		
		if(dbData.isPresent()) {
			this.repository.delete(dbData.get());
		}else {
			throw new ResourceNotFoundException("Record not found with work id : " + workId);
		}
	}

}

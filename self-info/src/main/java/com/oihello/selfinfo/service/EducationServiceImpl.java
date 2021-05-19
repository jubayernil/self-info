package com.oihello.selfinfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oihello.selfinfo.entity.Education;
import com.oihello.selfinfo.exception.ResourceNotFoundException;
import com.oihello.selfinfo.repository.EducationRepository;

@Service
@Transactional
public class EducationServiceImpl implements EducationServiceInfc{
	
	@Autowired
	private EducationRepository repository;

	@Override
	public Education createEducation(Education education) {
		return repository.save(education);
	}

	@Override
	public List<Education> getAllEducations(long personId) {
		return this.repository.findByPersonPersonId(personId);
	}

	@Override
	public Education getEducationById(long educationId) {
		Optional<Education> dbData = this.repository.findById(educationId);

		if (dbData.isPresent()) {
			return dbData.get();
		} else {
			throw new ResourceNotFoundException("Record not found with education id : " + educationId);
		}
	}

	@Override
	public Education updateEducation(Education education) {
		Optional<Education> dbData = this.repository.findById(education.getEducationId());

		if (dbData.isPresent()) {
			Education updateData = dbData.get();
			updateData.setCollegeName(education.getCollegeName());
			updateData.setStartDate(education.getStartDate());
			updateData.setEndDate(education.getEndDate());
			updateData.setMajorSubject(education.getMajorSubject());
			repository.save(updateData);
			return updateData;
		} else {
			throw new ResourceNotFoundException("Record not found with education id : " + education.getEducationId());
		}
	}

	@Override
	public void deleteEducation(long educationId) {
		Optional<Education> dbData = this.repository.findById(educationId);
		
		if(dbData.isPresent()) {
			this.repository.delete(dbData.get());
		}else {
			throw new ResourceNotFoundException("Record not found with education id : " + educationId);
		}
	}
}

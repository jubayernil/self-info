package com.oihello.selfinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oihello.selfinfo.entity.ProjectExperience;

@Repository
public interface ProjectExperienceRepository extends JpaRepository<ProjectExperience, Long> {
	List<ProjectExperience> findByPersonPersonIdAndWorkExperienceWorkId(long personId, long workId);
}
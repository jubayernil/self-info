package com.oihello.selfinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oihello.selfinfo.entity.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
	List<Education> findByPersonPersonId(long personId);
}

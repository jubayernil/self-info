package com.oihello.selfinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oihello.selfinfo.entity.Person;
import com.oihello.selfinfo.entity.ProjectExperience;
import com.oihello.selfinfo.entity.WorkExperience;
import com.oihello.selfinfo.service.ProjectExperienceServiceInfc;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ProjectExperienceController {
	
	@Autowired
	private ProjectExperienceServiceInfc service;
	
	@GetMapping("persons/{personId}/workexps/{workId}/projects")
	public ResponseEntity<List<ProjectExperience>> getAllProjectExperiences(
			@PathVariable long personId, 
			@PathVariable long workId){
		return ResponseEntity.ok().body(service.getAllProjectExperiences(personId, workId));
	}
	
	@GetMapping("persons/{personId}/workexps/{workId}/projects/{projectId}")
	public ResponseEntity<ProjectExperience> getProjectExperienceById(@PathVariable long projectId){
		return ResponseEntity.ok().body(service.getProjectExperienceById(projectId));
	}
	
	@PostMapping("persons/{personId}/workexps/{workId}/projects")
	public ResponseEntity<ProjectExperience> createProjectExperience(
			@PathVariable long personId, 
			@PathVariable long workId, 
			@RequestBody ProjectExperience projectExperience){
		projectExperience.setPerson(new Person(personId));
		projectExperience.setWorkExperience(new WorkExperience(workId));
		return ResponseEntity.ok().body(this.service.createProjectExperience(projectExperience));
	}
	
	@PutMapping("persons/{personId}/workexps/{workId}/projects/{projectId}")
	public ResponseEntity<ProjectExperience> updateWorkExperience(
			@PathVariable long personId, 
			@PathVariable long workId, 
			@PathVariable long projectId, 
			@RequestBody ProjectExperience projectExperience){
		projectExperience.setPerson(new Person(personId));
		projectExperience.setWorkExperience(new WorkExperience(workId));
		projectExperience.setProjectId(projectId);
		return ResponseEntity.ok().body(this.service.updateProjectExperience(projectExperience));
	}

	@DeleteMapping("persons/{personId}/workexps/{workId}/projects/{projectId}")
	public HttpStatus deleteAddress(@PathVariable long projectId){
		this.service.deleteProjectExperience(projectId);
		return HttpStatus.OK;
	}

}

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
import com.oihello.selfinfo.entity.WorkExperience;
import com.oihello.selfinfo.service.WorkExperienceServiceInfc;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class WorkExperienceController {
	
	@Autowired
	private WorkExperienceServiceInfc service;
	
	@GetMapping("persons/{personId}/workexps")
	public ResponseEntity<List<WorkExperience>> getAllWorkExperiences(@PathVariable long personId){
		return ResponseEntity.ok().body(service.getAllWorkExperiences(personId));
	}
	
	@GetMapping("persons/{personId}/workexps/{workId}")
	public ResponseEntity<WorkExperience> getWorkExperienceById(@PathVariable long workId){
		return ResponseEntity.ok().body(service.getWorkExperienceById(workId));
	}
	
	@PostMapping("persons/{personId}/workexps")
	public ResponseEntity<WorkExperience> createWorkExperience(@PathVariable long personId, @RequestBody WorkExperience workExperience){
		workExperience.setPerson(new Person(personId));
		return ResponseEntity.ok().body(this.service.createWorkExperience(workExperience));
	}
	
	@PutMapping("persons/{personId}/workexps/{workId}")
	public ResponseEntity<WorkExperience> updateWorkExperience(@PathVariable long personId, @PathVariable long workId, @RequestBody WorkExperience workExperience){
		workExperience.setPerson(new Person(personId));
		workExperience.setWorkId(workId);
		return ResponseEntity.ok().body(this.service.updateWorkExperience(workExperience));
	}

	@DeleteMapping("persons/{personId}/workexps/{workId}")
	public HttpStatus deleteAddress(@PathVariable long workId){
		this.service.deleteWorkExperience(workId);
		return HttpStatus.OK;
	}

}

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

import com.oihello.selfinfo.entity.Education;
import com.oihello.selfinfo.entity.Person;
import com.oihello.selfinfo.service.EducationServiceInfc;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EducationController {
	
	@Autowired
	private EducationServiceInfc service;
	
	@GetMapping("persons/{personId}/education")
	public ResponseEntity<List<Education>> getAllAssresses(@PathVariable long personId){
		return ResponseEntity.ok().body(service.getAllEducations(personId));
	}
	
	@GetMapping("persons/{personId}/education/{educationId}")
	public ResponseEntity<Education> getEducationById(@PathVariable long educationId){
		return ResponseEntity.ok().body(service.getEducationById(educationId));
	}
	
	@PostMapping("persons/{personId}/education")
	public ResponseEntity<Education> createEducation(@PathVariable long personId, @RequestBody Education education){
		education.setPerson(new Person(personId));
		return ResponseEntity.ok().body(this.service.createEducation(education));
	}
	
	@PutMapping("persons/{personId}/education/{educationId}")
	public ResponseEntity<Education> updateEducation(@PathVariable long personId, @PathVariable long educationId, @RequestBody Education education){
		education.setPerson(new Person(personId));
		education.setEducationId(educationId);
		return ResponseEntity.ok().body(this.service.updateEducation(education));
	}

	@DeleteMapping("persons/{personId}/education/{educationId}")
	public HttpStatus deleteEducation(@PathVariable long educationId){
		this.service.deleteEducation(educationId);
		return HttpStatus.OK;
	}

}

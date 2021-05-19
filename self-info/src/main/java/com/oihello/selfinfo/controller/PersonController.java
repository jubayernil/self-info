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
import com.oihello.selfinfo.service.PersonServiceInfc;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PersonController {
	
	@Autowired
	private PersonServiceInfc service;
	
	@GetMapping("/persons")
	public ResponseEntity<List<Person>> getAllPerson(){
		return ResponseEntity.ok().body(service.getAllPersons());
	}
	
	@GetMapping("/persons/{personId}")
	public ResponseEntity<Person> getPersonById(@PathVariable long personId){
		return ResponseEntity.ok().body(service.getPersonById(personId));
	}
	
	@PostMapping("/persons")
	public ResponseEntity<Person> createPerson(@RequestBody Person person){
		return ResponseEntity.ok().body(this.service.createPerson(person));
	}
	
	@PutMapping("/persons/{personId}")
	public ResponseEntity<Person> updatePerson(@PathVariable long personId, @RequestBody Person person){
		person.setPersonId(personId);
		return ResponseEntity.ok().body(this.service.updatePerson(person));
	}

	@DeleteMapping("/persons/{personId}")
	public HttpStatus deletePerson(@PathVariable long personId){
		this.service.deletePerson(personId);
		return HttpStatus.OK;
	}

}

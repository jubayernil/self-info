package com.oihello.selfinfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oihello.selfinfo.entity.Person;
import com.oihello.selfinfo.exception.ResourceNotFoundException;
import com.oihello.selfinfo.repository.PersonRepository;

@Service
@Transactional
public class PersonServiceImpl implements PersonServiceInfc{
	
	@Autowired
	private PersonRepository repository;

	@Override
	public Person createPerson(Person person) {
		return repository.save(person);
	}

	@Override
	public List<Person> getAllPersons() {
		return this.repository.findAll();
	}

	@Override
	public Person getPersonById(long personId) {
		Optional<Person> dbData = this.repository.findById(personId);

		if (dbData.isPresent()) {
			return dbData.get();
		} else {
			throw new ResourceNotFoundException("Record not found with person id : " + personId);
		}
	}

	@Override
	public Person updatePerson(Person person) {
		Optional<Person> dbData = this.repository.findById(person.getPersonId());

		if (dbData.isPresent()) {
			Person updateData = dbData.get();
			updateData.setPersonId(person.getPersonId());
			updateData.setFullName(person.getFullName());
			updateData.setEmail(person.getEmail());
			updateData.setCareerSummary(person.getCareerSummary());
			updateData.setCareerObjective(person.getCareerObjective());
			repository.save(updateData);
			return updateData;
		} else {
			throw new ResourceNotFoundException("Record not found with person id : " + person.getPersonId());
		}
	}

	@Override
	public void deletePerson(long personId) {
		Optional<Person> dbData = this.repository.findById(personId);
		
		if(dbData.isPresent()) {
			this.repository.delete(dbData.get());
		}else {
			throw new ResourceNotFoundException("Record not found with person id : " + personId);
		}
	}

}

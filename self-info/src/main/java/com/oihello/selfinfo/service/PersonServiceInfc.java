package com.oihello.selfinfo.service;

import java.util.List;

import com.oihello.selfinfo.entity.Person;

public interface PersonServiceInfc {
	
	Person createPerson(Person person);
	
	List<Person> getAllPersons();

	Person getPersonById(long personId);

	Person updatePerson(Person person);

	void deletePerson(long personId);
}

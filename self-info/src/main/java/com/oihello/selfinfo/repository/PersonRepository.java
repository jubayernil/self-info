package com.oihello.selfinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oihello.selfinfo.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}

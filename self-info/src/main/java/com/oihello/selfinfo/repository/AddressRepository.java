package com.oihello.selfinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oihello.selfinfo.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	List<Address> findByPersonPersonId(long personId);
}

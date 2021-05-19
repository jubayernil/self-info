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

import com.oihello.selfinfo.entity.Address;
import com.oihello.selfinfo.entity.Person;
import com.oihello.selfinfo.service.AddressServiceInfc;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AddressController {
	
	@Autowired
	private AddressServiceInfc service;
	
	@GetMapping("persons/{personId}/address")
	public ResponseEntity<List<Address>> getAllAssresses(@PathVariable long personId){
		return ResponseEntity.ok().body(service.getAllAddresses(personId));
	}
	
	@GetMapping("persons/{personId}/address/{addressId}")
	public ResponseEntity<Address> getAddressById(@PathVariable long addressId){
		return ResponseEntity.ok().body(service.getAddressById(addressId));
	}
	
	@PostMapping("persons/{personId}/address")
	public ResponseEntity<Address> createAddress(@PathVariable long personId, @RequestBody Address address){
		address.setPerson(new Person(personId));
		return ResponseEntity.ok().body(this.service.createAddress(address));
	}
	
	@PutMapping("persons/{personId}/address/{addressId}")
	public ResponseEntity<Address> updateAddress(@PathVariable long personId, @PathVariable long addressId, @RequestBody Address address){
		address.setPerson(new Person(personId));
		address.setAddressId(addressId);
		return ResponseEntity.ok().body(this.service.updateAddress(address));
	}

	@DeleteMapping("persons/{personId}/address/{addressId}")
	public HttpStatus deleteAddress(@PathVariable long addressId){
		this.service.deleteAddress(addressId);
		return HttpStatus.OK;
	}

}

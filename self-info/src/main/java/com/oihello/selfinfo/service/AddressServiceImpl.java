package com.oihello.selfinfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oihello.selfinfo.entity.Address;
import com.oihello.selfinfo.exception.ResourceNotFoundException;
import com.oihello.selfinfo.repository.AddressRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressServiceInfc{
	
	@Autowired
	private AddressRepository repository;

	@Override
	public Address createAddress(Address address) {
		return repository.save(address);
	}

	@Override
	public List<Address> getAllAddresses(long personId) {
		return this.repository.findByPersonPersonId(personId);
	}

	@Override
	public Address getAddressById(long addressId) {
		Optional<Address> dbData = this.repository.findById(addressId);

		if (dbData.isPresent()) {
			return dbData.get();
		} else {
			throw new ResourceNotFoundException("Record not found with address id : " + addressId);
		}
	}

	@Override
	public Address updateAddress(Address address) {
		Optional<Address> dbData = this.repository.findById(address.getAddressId());

		if (dbData.isPresent()) {
			Address updateData = dbData.get();
			updateData.setStreetAddress(address.getStreetAddress());
			updateData.setZipcode(address.getZipcode());
			updateData.setState(address.getState());
			updateData.setCountry(address.getCountry());
			repository.save(updateData);
			return updateData;
		} else {
			throw new ResourceNotFoundException("Record not found with address id : " + address.getAddressId());
		}
	}

	@Override
	public void deleteAddress(long addressId) {
		Optional<Address> dbData = this.repository.findById(addressId);
		
		if(dbData.isPresent()) {
			this.repository.delete(dbData.get());
		}else {
			throw new ResourceNotFoundException("Record not found with address id : " + addressId);
		}
	}

}

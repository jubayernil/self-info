package com.oihello.selfinfo.service;

import java.util.List;

import com.oihello.selfinfo.entity.Address;

public interface AddressServiceInfc {
	
	Address createAddress(Address address);
	
	List<Address> getAllAddresses(long personId);

	Address getAddressById(long addressId);

	Address updateAddress(Address address);

	void deleteAddress(long addressId);
}

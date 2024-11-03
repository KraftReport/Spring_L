package com.kraft.customer.services;

import org.springframework.stereotype.Component;

import com.kraft.customer.models.Customer;
import com.kraft.customer.models.CustomerRequestDto;

@Component
public class CustomerMapper {

	public Customer mapToCustomer(CustomerRequestDto customerDto) {
		return Customer.builder()
				.firstName(customerDto.firstName())
				.lastName(customerDto.lastName())
				.build();
	}
}

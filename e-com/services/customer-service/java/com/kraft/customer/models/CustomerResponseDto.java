package com.kraft.customer.models;

public record CustomerResponseDto(
		String id,
		String firstName,
		String lastName,
		String email,
		Address address) {

}

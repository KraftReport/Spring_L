package com.kraft.customer.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequestDto(
		@NotNull(message = "id cannot be empty or null") String id,
		@NotNull(message = "firstName cannot be empty or null") String firstName,
		@NotNull(message = "lastName cannot be empty or null") String lastName,
		@Email(message = "email is not in valid format") String email,
		Address address) {

}

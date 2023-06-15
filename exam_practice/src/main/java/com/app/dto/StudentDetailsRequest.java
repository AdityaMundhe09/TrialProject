package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDetailsRequest {

	@NotBlank(message = "firstName should not be null")
	private String firstName;
	@NotBlank(message = "lastName should not be null")
	private String lastName;
	@NotBlank(message = "email should not be null")
	@Email(message = "email not valid")
	private String email;
	@NotNull(message = "marks should not be blank")
	private double scoreObtained;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String courseTitle;
}

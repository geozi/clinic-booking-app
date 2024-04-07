package com.myclinic.service.dto.insertion;

import com.myclinic.model.Patient;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The {@link PatientInsertDTO} class is the DTO equivalent
 * of the {@link Patient} class, adjusted for inserting
 * operations.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientInsertDTO {
	@NotNull
	@Size(min = 2, max = 45, message = "Patient firstname must be between 2 and 45 characters")
	private String firstname;
	@NotNull
	@Size(min = 2, max = 45, message = "Patient lastname must be between 2 and 45 characters")
	private String lastname;
	@NotNull
	@Size(min = 10, max = 20, message = "Patient phone number must be between 10 and 20 characters")
	private String phoneNumber;
	@NotNull
	private String email;
	@NotNull
	private String streetAddress;
	@NotNull
	@Size(min = 2, max = 45, message = "Patient city must be between 2 and 45 characters")
	private String city;

}

package com.myclinic.service.dto.update;

import com.myclinic.model.Patient;
import com.myclinic.service.dto.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The {@link PatientUpdateDTO} class is the DTO equivalent of the
 * {@link Patient} class, adjusted for updating operations.
 * It inherits from the {@link BaseDTO} class.
 */
@NoArgsConstructor
@Getter
@Setter
public class PatientUpdateDTO extends BaseDTO {

	private String firstname;
	private String lastname;
	private String phoneNumber;
	private String email;
	private String streetAddress;
	private String city;
	
	public PatientUpdateDTO(Long id, String firstname, String lastname, String phoneNumber, String email, String streetAddress,
			String city) {
		super.setId(id);
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.streetAddress = streetAddress;
		this.city = city;
	}
	
}

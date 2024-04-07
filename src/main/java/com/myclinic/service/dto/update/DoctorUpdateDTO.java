package com.myclinic.service.dto.update;

import com.myclinic.model.Doctor;
import com.myclinic.model.enumfields.SpecialtyType;
import com.myclinic.service.dto.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The {@link DoctorUpdateDTO} class is the DTO equivalent of the
 * {@link Doctor} class, adjusted for updating operations.
 * It inherits from the {@link BaseDTO} class.
 */
@NoArgsConstructor
@Getter
@Setter
public class DoctorUpdateDTO extends BaseDTO {

	private String firstname;
	private String lastname;
	private SpecialtyType specialty;
	private String phoneNumber;
	private String email;
	private String streetAddress;
	private String city;

	public DoctorUpdateDTO(Long id, String firstname, String lastname, SpecialtyType specialty, String phoneNumber, String email,
			String streetAddress, String city) {
		super.setId(id);
		this.firstname = firstname;
		this.lastname = lastname;
		this.specialty = specialty;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.streetAddress = streetAddress;
		this.city = city;
	}
}

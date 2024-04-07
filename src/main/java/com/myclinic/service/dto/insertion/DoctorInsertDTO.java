package com.myclinic.service.dto.insertion;

import com.myclinic.model.Doctor;
import com.myclinic.model.enumfields.SpecialtyType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The {@link DoctorInsertDTO} class is the DTO equivalent
 * of the {@link Doctor} class, adjusted for inserting
 * operations.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorInsertDTO {

	private String firstname;
	private String lastname;
	private SpecialtyType specialty;
	private String phoneNumber;
	private String email;
	private String streetAddress;
	private String city;
}

package com.myclinic.service.util.validation.insertion;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myclinic.model.enumfields.SpecialtyType;
import com.myclinic.service.dto.insertion.DoctorInsertDTO;

@Component
public class DoctorInsertValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return DoctorInsertDTO.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		DoctorInsertDTO doctorInsertDTO = (DoctorInsertDTO) target;

		String firstname = doctorInsertDTO.getFirstname();
		String lastname = doctorInsertDTO.getLastname();
		SpecialtyType specialty = doctorInsertDTO.getSpecialty();
		String phoneNumber = doctorInsertDTO.getPhoneNumber();
		String email = doctorInsertDTO.getEmail();
		String streetAddress = doctorInsertDTO.getStreetAddress();
		String city = doctorInsertDTO.getCity();
		
		
		if(firstname == null) errors.rejectValue("firstname", "NotNull");
		ValidationUtils.rejectIfEmpty(errors, "firstname", "empty");
		if(firstname.length() < 2 || firstname.length() > 45) errors.rejectValue("firstname", "firstnameSize");
		
		if(lastname == null) errors.rejectValue("lastname", "NotNull");
		ValidationUtils.rejectIfEmpty(errors, "lastname", "empty");
		if(lastname.length() < 2 || lastname.length() > 45) errors.rejectValue("lastname", "lastnameSize");
		
		if(specialty == null) errors.rejectValue("specialty", "NotNull");
		
		if(phoneNumber == null) errors.rejectValue("phoneNumber", "NotNull");
		ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "empty");
		if(phoneNumber.length() < 10 || phoneNumber.length() > 10) errors.rejectValue("phoneNumber", "phoneNumberSize");
		
		if(email == null) errors.rejectValue("email", "NotNull");
		ValidationUtils.rejectIfEmpty(errors, "email", "empty");
		
		if(streetAddress == null) errors.rejectValue("streetAddress", "NotNull");
		ValidationUtils.rejectIfEmpty(errors, "streetAddress", "empty");
		
 		if(city == null) errors.rejectValue("city", "NotNull");
 		ValidationUtils.rejectIfEmpty(errors, "city", "empty");
 		if(city.length() < 2 || city.length() > 45) errors.rejectValue("city", "citySize");
	}
	
	

}

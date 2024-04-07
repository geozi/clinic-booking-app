package com.myclinic.service.util.validation.update;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.myclinic.service.dto.update.DoctorUpdateDTO;
import com.myclinic.service.dto.update.RoomUpdateDTO;

@Component
public class RoomUpdateValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return DoctorUpdateDTO.class==clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		RoomUpdateDTO roomUpdateDTO = (RoomUpdateDTO) target;
		
		if(roomUpdateDTO.getNumber() == null) {
			errors.reject("number", "NotNull");
		}
		
		if(roomUpdateDTO.getCapacity() == null) {
			errors.reject("capacity", "NotNull");
		}
		
		
	}
	
	

}

package com.myclinic.service.util.validation.insertion;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.myclinic.service.dto.insertion.RoomInsertDTO;

@Component
public class RoomInsertValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RoomInsertDTO.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		RoomInsertDTO roomInsertDTO = (RoomInsertDTO) target;
		
		
		if(roomInsertDTO.getNumber() == null) {
			errors.reject("number", "NotNull");
		}
		
		if(roomInsertDTO.getCapacity() == null) {
			errors.reject("capacity", "NotNull");
		}
		
	}
	
	

}

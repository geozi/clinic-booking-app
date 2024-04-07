package com.myclinic.service.util.mapper;

import com.myclinic.model.Patient;
import com.myclinic.service.dto.insertion.PatientInsertDTO;
import com.myclinic.service.dto.readonly.PatientReadOnlyDTO;
import com.myclinic.service.dto.update.PatientUpdateDTO;

/**
 * The {@link PatientMapper} class is a utility class
 * that maps DTOs to the Patient model class and vice versa.
 */
public class PatientMapper {
	
	private PatientMapper() {} 
	
	public static Patient mapToPatient(PatientInsertDTO dto) {
		return new Patient(dto.getFirstname(), dto.getLastname(), dto.getPhoneNumber(), 
				dto.getEmail(), dto.getStreetAddress(), dto.getCity());
	}
	
	public static Patient mapToPatient(PatientUpdateDTO dto) {
		return new Patient(dto.getId(), dto.getFirstname(), dto.getLastname(),
				dto.getPhoneNumber(), dto.getEmail(), dto.getStreetAddress(), dto.getCity());
	}

	public static PatientReadOnlyDTO mapToReadOnlyDTO(Patient patient) {
		return new PatientReadOnlyDTO(patient.getId(), patient.getFirstname(), patient.getLastname(), 
				patient.getPhoneNumber(), patient.getEmail(), patient.getStreetAddress(), patient.getCity());
	}

}

package com.myclinic.service.util.mapper;


import com.myclinic.model.Doctor;
import com.myclinic.service.dto.insertion.DoctorInsertDTO;
import com.myclinic.service.dto.readonly.DoctorReadOnlyDTO;
import com.myclinic.service.dto.update.DoctorUpdateDTO;

/**
 * The {@link DoctorMapper} class is a utility class
 * that maps DTOs to the Doctor model class and vice versa.
 */
public class DoctorMapper {
	
	private DoctorMapper() {}
	
	public static Doctor mapToDoctor(DoctorInsertDTO dto) {
		return new Doctor(dto.getFirstname(), dto.getLastname(), dto.getSpecialty(), 
				dto.getPhoneNumber(), dto.getEmail(), dto.getStreetAddress(), dto.getCity());
	}
	
	public static Doctor mapToDoctor(DoctorUpdateDTO dto) {
		return new Doctor(dto.getId(), dto.getFirstname(), dto.getLastname(), dto.getSpecialty(), 
				dto.getPhoneNumber(), dto.getEmail(), dto.getStreetAddress(), dto.getCity());
	}
	
	public static DoctorReadOnlyDTO mapToReadOnlyDTO(Doctor doctor) {
		return new DoctorReadOnlyDTO(doctor.getId(), doctor.getFirstname(), doctor.getLastname(), 
				doctor.getSpecialty(), doctor.getPhoneNumber(), doctor.getEmail(), doctor.getStreetAddress(), doctor.getCity());
	}
}

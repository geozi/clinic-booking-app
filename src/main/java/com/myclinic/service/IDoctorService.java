package com.myclinic.service;

import com.myclinic.model.Doctor;
import com.myclinic.service.dto.insertion.DoctorInsertDTO;
import com.myclinic.service.dto.update.DoctorUpdateDTO;
import com.myclinic.service.exceptions.EntityNotFoundException;

/**
 * The {@link IDoctorService} interface contains 
 * the Service-layer definitions of the CRUD methods 
 * for the Doctor primary entity.
 */
public interface IDoctorService {
	Doctor insertDoctor(DoctorInsertDTO dto) throws Exception;
	Doctor updateDoctor(DoctorUpdateDTO dto) throws EntityNotFoundException;
	Doctor deleteDoctor(Long id) throws EntityNotFoundException;
}

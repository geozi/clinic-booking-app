package com.myclinic.service;

import com.myclinic.model.Patient;
import com.myclinic.service.dto.insertion.PatientInsertDTO;
import com.myclinic.service.dto.update.PatientUpdateDTO;
import com.myclinic.service.exceptions.EntityNotFoundException;

/**
 * The {@link IPatientService} interface contains 
 * the Service-layer definitions of the CRUD methods 
 * for the Patient primary entity.
 */
public interface IPatientService {
	Patient insertPatient(PatientInsertDTO dto) throws Exception;
	Patient updatePatient(PatientUpdateDTO dto) throws EntityNotFoundException;
	Patient deletePatient(Long id) throws EntityNotFoundException;
}

package com.myclinic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclinic.model.Patient;
import com.myclinic.repository.PatientRepository;
import com.myclinic.service.dto.insertion.PatientInsertDTO;
import com.myclinic.service.dto.update.PatientUpdateDTO;
import com.myclinic.service.exceptions.EntityNotFoundException;
import com.myclinic.service.util.mapper.PatientMapper;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 * The {@link PatientServiceImpl} class implements the
 * CRUD wrapper methods as defined in the {@link IPatientService}
 * interface.
 */
@Service
@Slf4j
public class PatientServiceImpl implements IPatientService {
	
	private final  PatientRepository patientRepository;
	
	@Autowired
	public PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	@Transactional
	@Override
	public Patient insertPatient(PatientInsertDTO dto) throws Exception {
		
		Patient patient= null;
		
		try {
			patient = patientRepository.save(PatientMapper.mapToPatient(dto));
			if(patient.getId() == null) throw new Exception("Insert Error");
		} catch (Exception e) {
			log.info("Insert Error");
			throw e;
		}
		
		return patient;
	}
	
	@Transactional
	@Override
	public Patient updatePatient(PatientUpdateDTO dto) throws EntityNotFoundException {
		
		Optional<Patient> optionalPatient;
		Patient updatedPatient = null;
		
		try {
			optionalPatient = patientRepository.findById(dto.getId());
			if(optionalPatient.get() == null) throw new EntityNotFoundException(Patient.class, dto.getId());
			updatedPatient = patientRepository.save(PatientMapper.mapToPatient(dto));
		} catch (Exception e) {
			log.info("Update error");
			throw e;
		}
		
		return updatedPatient;
	}
	
	@Transactional
	@Override
	public Patient deletePatient(Long id) throws EntityNotFoundException {

		Optional<Patient> optionalPatient;
		Patient patient = null;
		
		try {
			optionalPatient = patientRepository.findById(id);
			patient = optionalPatient.get();
			if(patient == null) throw new EntityNotFoundException(Patient.class, id);
			patientRepository.delete(patient);
		} catch (EntityNotFoundException e) {
			log.info("Deletion error");
			throw e;
		}
		return patient;
	}
	
}

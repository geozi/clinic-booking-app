package com.myclinic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclinic.model.Doctor;
import com.myclinic.repository.DoctorRepository;
import com.myclinic.service.dto.insertion.DoctorInsertDTO;
import com.myclinic.service.dto.update.DoctorUpdateDTO;
import com.myclinic.service.exceptions.EntityNotFoundException;
import com.myclinic.service.util.mapper.DoctorMapper;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 * The {@link DoctorServiceImpl} class implements the
 * CRUD wrapper methods as defined in the {@link IDoctorService}
 * interface.
 */
@Service
@Slf4j
public class DoctorServiceImpl implements IDoctorService {
	
	private final DoctorRepository doctorRepository;
	
	@Autowired
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	
	@Transactional
	@Override
	public Doctor insertDoctor(DoctorInsertDTO dto) throws Exception {
		Doctor doctor = null;
		
		try {
			doctor = doctorRepository.save(DoctorMapper.mapToDoctor(dto));
			if(doctor.getId() == null) throw new Exception("Insert Error");
		} catch (Exception e) {
			log.info("Insert Error");
			throw e;
		}
		
		return doctor;
	}
	
	@Transactional
	@Override
	public Doctor updateDoctor(DoctorUpdateDTO dto) throws EntityNotFoundException {
		Optional<Doctor> optionalDoctor;
		Doctor updatedDoctor = null;
		
		try {
			optionalDoctor = doctorRepository.findById(dto.getId());
			if(optionalDoctor.get() == null) throw new EntityNotFoundException(Doctor.class, dto.getId());
			updatedDoctor = doctorRepository.save(DoctorMapper.mapToDoctor(dto));
		} catch (Exception e) {
			log.info("Update error");
			throw e;
		}
		
		return updatedDoctor;
	}

	@Override
	public Doctor deleteDoctor(Long id) throws EntityNotFoundException {
		Optional<Doctor> optionalDoctor;
		Doctor doctor = null;
		try {
			optionalDoctor = doctorRepository.findById(id);
			doctor = optionalDoctor.get();
			if(doctor == null) throw new EntityNotFoundException(Doctor.class, id);
			doctorRepository.delete(doctor);
		} catch (EntityNotFoundException e) {
			log.info("Deletion error");
			throw e;

		}
		
		return doctor;
	}
}

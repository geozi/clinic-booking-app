package com.myclinic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclinic.model.Appointment;
import com.myclinic.repository.AppointmentRepository;
import com.myclinic.service.dto.insertion.AppointmentInsertDTO;
import com.myclinic.service.dto.update.AppointmentUpdateDTO;
import com.myclinic.service.exceptions.EntityNotFoundException;
import com.myclinic.service.util.mapper.AppointmentMapper;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 * The {@link AppointmentServiceImpl} class implements the
 * CRUD wrapper methods as defined in the {@link IAppointmentService}
 * interface.
 */
@Service
@Slf4j
public class AppointmentServiceImpl implements IAppointmentService {
	private final AppointmentRepository appointmentRepository;
	
	@Autowired
	public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}
	
	@Transactional
	@Override
	public Appointment insertAppointment(AppointmentInsertDTO dto) throws Exception {
		Appointment appointment = null;
		
		try {
			appointment = appointmentRepository.save(AppointmentMapper.mapToAppointment(dto));
			if(appointment.getId() == null) throw new Exception("Insert Error");
		} catch (Exception e) {
			log.info("Insert Error");
			throw e;
		}
		
		return appointment;
	}
	
	@Transactional
	@Override
	public Appointment updateAppointment(AppointmentUpdateDTO dto) throws EntityNotFoundException {
		
		Optional<Appointment> optionalAppointment;
		Appointment updatedAppointment = null;
		
		try {
			optionalAppointment = appointmentRepository.findById(dto.getId());
			if(optionalAppointment.get() == null) throw new EntityNotFoundException(Appointment.class, dto.getId());
			updatedAppointment = appointmentRepository.save(AppointmentMapper.mapToAppointment(dto));
		} catch (Exception e) {
			log.info("Update error");
			throw e;
		}
		
		return updatedAppointment;
	}

	@Transactional
	@Override
	public Appointment deleteAppointment(Long id) throws EntityNotFoundException {
		Optional<Appointment> optionalAppointment;
		Appointment appointment = null;
		
		try {
			optionalAppointment = appointmentRepository.findById(id);
			appointment = optionalAppointment.get();
			if(appointment == null) throw new EntityNotFoundException(Appointment.class, id);
			appointmentRepository.delete(appointment);
		} catch (EntityNotFoundException e) {
			log.info("Deletion error");
			throw e;
		}
		return appointment;
	}
}

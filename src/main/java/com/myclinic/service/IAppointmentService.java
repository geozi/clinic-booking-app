package com.myclinic.service;

import com.myclinic.model.Appointment;
import com.myclinic.service.dto.insertion.AppointmentInsertDTO;
import com.myclinic.service.dto.update.AppointmentUpdateDTO;
import com.myclinic.service.exceptions.EntityNotFoundException;

/**
 * The {@link IAppointmentService} interface contains 
 * the Service-layer definitions of the CRUD methods 
 * for the Appointment primary entity.
 */
public interface IAppointmentService {
	Appointment insertAppointment(AppointmentInsertDTO dto) throws Exception;
	Appointment updateAppointment(AppointmentUpdateDTO dto) throws EntityNotFoundException;
	Appointment deleteAppointment(Long id) throws EntityNotFoundException;
}

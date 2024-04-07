package com.myclinic.service.util.mapper;


import com.myclinic.model.Appointment;
import com.myclinic.service.dto.insertion.AppointmentInsertDTO;
import com.myclinic.service.dto.readonly.AppointmentReadOnlyDTO;
import com.myclinic.service.dto.update.AppointmentUpdateDTO;

/**
 * The {@link AppointmentMapper} class is a utility class
 * that maps DTOs to the Appointment model class and vice versa.
 */
public class AppointmentMapper {
	
	private AppointmentMapper() {}
	
	public static Appointment mapToAppointment(AppointmentInsertDTO dto) {
		return new Appointment(dto.getAppointmentDate(), dto.getTime(), dto.getStatus(), 
				dto.getPatient(), dto.getDoctor(), dto.getRoom());
	}
	
	public static Appointment mapToAppointment(AppointmentUpdateDTO dto) {
		return new Appointment(dto.getId(), dto.getAppointmentDate(), dto.getTime(), dto.getStatus(), 
				dto.getPatient(), dto.getDoctor(), dto.getRoom());
	}
	
	public static AppointmentReadOnlyDTO mapToReadOnlyDTO(Appointment appointment) {
		return new AppointmentReadOnlyDTO(appointment.getId(), appointment.getAppointmentDate(), appointment.getTime(), 
				appointment.getStatus(),appointment.getPatient(), appointment.getDoctor(), appointment.getRoom());
	}
 }

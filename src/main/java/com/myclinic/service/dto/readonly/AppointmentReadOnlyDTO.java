package com.myclinic.service.dto.readonly;

import java.time.LocalDate;
import java.time.LocalTime;

import com.myclinic.model.Appointment;
import com.myclinic.model.Doctor;
import com.myclinic.model.Patient;
import com.myclinic.model.Room;
import com.myclinic.model.enumfields.StatusType;
import com.myclinic.service.dto.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The {@link AppointmentReadOnlyDTO} class is the DTO equivalent of the
 * {@link Appointment} class, adjusted for read-only operations.
 * It inherits from the {@link BaseDTO} class.
 */
@NoArgsConstructor
@Getter
@Setter
public class AppointmentReadOnlyDTO extends BaseDTO{

	private LocalDate appointmentDate;
	private LocalTime time;
	private StatusType status;
	private Patient patient;
	private Doctor doctor;
	private Room room;

	public AppointmentReadOnlyDTO(Long id, LocalDate appointmentDate, LocalTime time, StatusType status, Patient patient,
			Doctor doctor, Room room) {
		super.setId(id);
		this.appointmentDate = appointmentDate;
		this.time = time;
		this.status = status;
		this.patient = patient;
		this.doctor = doctor;
		this.room = room;
	}
	
	
}

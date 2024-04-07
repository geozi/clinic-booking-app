package com.myclinic.service.dto.insertion;

import java.time.LocalDate;
import java.time.LocalTime;

import com.myclinic.model.Appointment;
import com.myclinic.model.Doctor;
import com.myclinic.model.Patient;
import com.myclinic.model.Room;
import com.myclinic.model.enumfields.StatusType;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The {@link AppointmentInsertDTO} class is the DTO equivalent
 * of the {@link Appointment} class, adjusted for inserting
 * operations.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppointmentInsertDTO {
	@NotNull
	private LocalDate appointmentDate;
	@NotNull
	private LocalTime time;
	@NotNull
	private StatusType status;
	@NotNull
	private Patient patient;
	@NotNull
	private Doctor doctor;
	@NotNull
	private Room room;

}

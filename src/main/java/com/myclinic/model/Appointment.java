package com.myclinic.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.myclinic.model.enumfields.StatusType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The {@link Appointment} class is an abstract representation
 * of an Appointment. It maps to an Appointment primary entity
 * in the database and inherits from the {@link AbstractModelEntity} class.
 */
@Entity
@NoArgsConstructor
@Table(name = "Appointments")
@Getter
@Setter
public class Appointment extends AbstractModelEntity {
	@Column(name = "Appointment_Date")
	private LocalDate appointmentDate;
	@Column(name = "Time")
	private LocalTime time;
	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private StatusType status;
	
	// Constructors

	public Appointment(LocalDate appointmentDate, LocalTime time, StatusType status, Patient patient, Doctor doctor,
			Room room) {
		this.appointmentDate = appointmentDate;
		this.time = time;
		this.status = status;
		this.patient = patient;
		this.doctor = doctor;
		this.room = room;
	}
	
	public Appointment(Long id, LocalDate appointmentDate, LocalTime time, StatusType status, Patient patient, Doctor doctor,
			Room room) {
		setId(id);
		this.appointmentDate = appointmentDate;
		this.time = time;
		this.status = status;
		this.patient = patient;
		this.doctor = doctor;
		this.room = room;
	}



	// Relations
	
	@ManyToOne(fetch = FetchType.EAGER) // For testing purposes
	@JoinColumn(name = "PatientID", referencedColumnName = "ID")
	private Patient patient;
	@ManyToOne(fetch = FetchType.EAGER) // For testing purposes
	@JoinColumn(name = "DoctorID", referencedColumnName = "ID")
	private Doctor doctor;
	@ManyToOne(fetch = FetchType.EAGER) // For testing purposes
	@JoinColumn(name = "RoomID", referencedColumnName = "ID")
	private Room room;
	
}

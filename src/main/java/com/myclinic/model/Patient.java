package com.myclinic.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The {@link Patient} class is an abstract representation
 * of a Patient. It maps to a Patient primary entity
 * in the database and inherits from the {@link AbstractModelEntity} class.
 */
@Entity
@NoArgsConstructor
@Table(name = "Patients", indexes = {
		@Index(name="lastname_idx", columnList = "Lastname"),
		@Index(name ="city_idx", columnList = "City")
})
@Getter
@Setter
public class Patient extends AbstractModelEntity {

	@Column(name = "Firstname", length = 45)
	private String firstname;
	@Column(name = "Lastname", length = 45)
	private String lastname;
	@Column(name = "Phone_Number" , length = 20)
	private String phoneNumber;
	@Column(name = "Email")
	private String email;
	@Column(name = "Street_Address")
	private String streetAddress;
	@Column(name = "City", length = 45)
	private String city;
	
	// Constructors
	
	public Patient(String firstname, String lastname, String phoneNumber, String email, String streetAddress,
			String city) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.streetAddress = streetAddress;
		this.city = city;
	}
	
	public Patient(Long id, String firstname, String lastname, String phoneNumber, String email, String streetAddress, String city) {
		setId(id);
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.streetAddress = streetAddress;
		this.city = city;
	}
	
	// Relations
	
	@OneToMany(mappedBy = "patient")
	@Getter(AccessLevel.PROTECTED)
	private Set<Appointment> appointments = new HashSet<>();
	
	// Convenient methods
	
	public Set<Appointment> getAllAppointments() {
		return Collections.unmodifiableSet(appointments);
	}
	
	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
		appointment.setPatient(this);
	}
	
}

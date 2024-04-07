package com.myclinic.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.myclinic.model.enumfields.SpecialtyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The {@link Doctor} class is an abstract representation
 * of a Doctor. It maps to a Doctor primary entity
 * in the database and inherits from the {@link AbstractModelEntity} class.
 */
@Entity
@NoArgsConstructor
@Table(name = "Doctors", indexes = {
		@Index(name="lastname_idx", columnList = "Lastname"),
		@Index(name ="specialty_idx", columnList = "Specialty"),
		@Index(name = "city_idx", columnList = "City")
})
@Getter
@Setter
public class Doctor extends AbstractModelEntity {
	
	@Column(name = "Firstname", length = 45)
	private String firstname;
	@Column(name = "Lastname", length = 45)
	private String lastname;
	@Column(name = "Specialty")
	@Enumerated(EnumType.STRING)
	private SpecialtyType specialty;
	@Column(name = "Phone_Number", length = 20)
	private String phoneNumber;
	@Column(name = "Email")
	private String email;
	@Column(name = "Street_Address")
	private String streetAddress;
	@Column(name = "City", length = 45)
	private String city;
	
	// Constructors
	
	public Doctor(String firstname, String lastname, SpecialtyType specialty, String phoneNumber, String email,
			String streetAddress, String city) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.specialty = specialty;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.streetAddress = streetAddress;
		this.city = city;
	}
	
	
	public Doctor(Long id, String firstname, String lastname, SpecialtyType specialty, String phoneNumber, String email,
			String streetAddress, String city) {
		setId(id);
		this.firstname = firstname;
		this.lastname = lastname;
		this.specialty = specialty;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.streetAddress = streetAddress;
		this.city = city;
	}
	
	// Relations
	
	@OneToMany(mappedBy = "doctor")
	@Getter(AccessLevel.PROTECTED)
	private Set<Appointment> appointments = new HashSet<>();
	
	// Convenient methods
	
	public Set<Appointment> getAllAppointments() {
		return Collections.unmodifiableSet(appointments);
	}
	
	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
		appointment.setDoctor(this);
	}



}

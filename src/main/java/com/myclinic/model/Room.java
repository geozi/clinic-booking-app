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
 * The {@link Room} class is an abstract representation
 * of a Room. It maps to a Room primary entity
 * in the database and inherits from the {@link AbstractModelEntity} class.
 */
@Entity
@NoArgsConstructor
@Table(name = "Rooms", indexes = {
		@Index(name = "number_idx", columnList = "Number"),
		@Index(name ="cap_idx", columnList = "Capacity")
})
@Getter
@Setter
public class Room extends AbstractModelEntity{
	@Column(name = "Number")
	private String number;
	@Column(name = "Capacity")
	private Integer capacity;
	
	// Constructors

	public Room(String number, Integer capacity) {
		this.number = number;
		this.capacity = capacity;
	}
	
	public Room(Long id, String number, Integer capacity) {
		setId(id);
		this.number = number;
		this.capacity = capacity;
	}
	
	// Relations
	
	@OneToMany(mappedBy = "room")
	@Getter(AccessLevel.PROTECTED)
	private Set<Appointment> appointments = new HashSet<>();
	
	// Convenient methods
	
	public Set<Appointment> getAllAppointments() {
		return Collections.unmodifiableSet(appointments);
	}
	
	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
		appointment.setRoom(this);
	}

}

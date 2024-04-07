package com.myclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myclinic.model.Appointment;

/**
 * Repository interface for managing appointments.
 * Provides CRUD operations for working with Appointment entities.
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}

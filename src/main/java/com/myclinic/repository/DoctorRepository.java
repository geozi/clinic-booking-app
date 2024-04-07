package com.myclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myclinic.model.Doctor;

/**
 * Repository interface for managing doctors.
 * Provides CRUD operations for working with Doctor entities.
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}

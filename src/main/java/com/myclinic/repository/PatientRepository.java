package com.myclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myclinic.model.Patient;

/**
 * Repository interface for managing patients.
 * Provides CRUD operations for working with Patient entities.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}

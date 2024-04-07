package com.myclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myclinic.model.Room;

/**
 * Repository interface for managing rooms.
 * Provides CRUD operations for working with Room entities.
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}

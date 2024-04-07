package com.myclinic.service;

import com.myclinic.model.Room;
import com.myclinic.service.dto.insertion.RoomInsertDTO;
import com.myclinic.service.dto.update.RoomUpdateDTO;
import com.myclinic.service.exceptions.EntityNotFoundException;

/**
 * The {@link IRoomService} interface contains 
 * the Service-layer definitions of the CRUD methods 
 * for the Room primary entity.
 */
public interface IRoomService {
	Room insertRoom(RoomInsertDTO dto) throws Exception;
	Room updateRoom(RoomUpdateDTO dto) throws EntityNotFoundException;
	Room deleteRoom(Long id) throws EntityNotFoundException;
	Room getRoomById(Long id) throws EntityNotFoundException;
}

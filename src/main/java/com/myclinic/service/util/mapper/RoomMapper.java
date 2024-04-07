package com.myclinic.service.util.mapper;

import com.myclinic.model.Room;
import com.myclinic.service.dto.insertion.RoomInsertDTO;
import com.myclinic.service.dto.readonly.RoomReadOnlyDTO;
import com.myclinic.service.dto.update.RoomUpdateDTO;

/**
 * The {@link RoomMapper} class is a utility class
 * that maps DTOs to the Room model class and vice versa.
 */
public class RoomMapper {
	
	private RoomMapper() {}
	
	public static Room mapToRoom(RoomInsertDTO dto) {
		return new Room(dto.getNumber(), dto.getCapacity());
	}
	
	public static Room mapToRoom(RoomUpdateDTO dto) {
		return new Room(dto.getId(), dto.getNumber(), dto.getCapacity());
	}
	
	public static RoomReadOnlyDTO mapToReadOnlyDTO(Room room) {
		return new RoomReadOnlyDTO(room.getId(), room.getNumber(), room.getCapacity()); 
	}

}

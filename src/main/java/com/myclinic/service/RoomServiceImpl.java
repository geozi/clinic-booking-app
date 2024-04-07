package com.myclinic.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.myclinic.model.Room;
import com.myclinic.repository.RoomRepository;
import com.myclinic.service.dto.insertion.RoomInsertDTO;
import com.myclinic.service.dto.update.RoomUpdateDTO;
import com.myclinic.service.exceptions.EntityNotFoundException;
import com.myclinic.service.util.mapper.RoomMapper;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 * The {@link RoomServiceImpl} class implements the
 * CRUD wrapper methods as defined in the {@link IRoomService}
 * interface.
 */
@Service
@Slf4j
public class RoomServiceImpl implements IRoomService {
	private final RoomRepository roomRepository;
	
	@Autowired
	public RoomServiceImpl(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	@Transactional
	@Override
	public Room insertRoom(RoomInsertDTO dto) throws Exception {
		Room room = null;
		
		try {
			room = roomRepository.save(RoomMapper.mapToRoom(dto));
			if(room.getId() == null) throw new Exception("Insert Error");
		} catch (Exception e) {
			log.info("Insert Error");
			throw e;
		}
		
		return room;
	}
	
	@Transactional
	@Override
	public Room updateRoom(RoomUpdateDTO dto) throws EntityNotFoundException {
		
		Optional<Room> optionalRoom;
		Room updatedRoom = null;
		
		try {
			optionalRoom = roomRepository.findById(dto.getId());
			if(optionalRoom.get() == null) throw new EntityNotFoundException(Room.class, dto.getId());
			updatedRoom = roomRepository.save(RoomMapper.mapToRoom(dto));
		} catch (Exception e) {
			log.info("Update error");
			throw e;
		}
		
		return updatedRoom;
	}
	
	@Transactional
	@Override
	public Room deleteRoom(Long id) throws EntityNotFoundException {
		Optional<Room> optionalRoom;
		Room room = null;
		
		try {
			optionalRoom = roomRepository.findById(id);
			room = optionalRoom.get();
			if(room == null) throw new EntityNotFoundException(Room.class, id);
			roomRepository.delete(room);
		} catch (EntityNotFoundException | NoSuchElementException e) {
			log.info("Deletion error");
			throw e;
		}
		return room;
	}
	
	@Transactional
	@Override
	public Room getRoomById(Long id) throws EntityNotFoundException {
		Optional<Room> optionalRoom;
		Room room;
		try {
			optionalRoom = roomRepository.findById(id);
			room = optionalRoom.get();
			if(room == null) throw new EntityNotFoundException(Room.class, id);
		} catch (EntityNotFoundException | NoSuchElementException e) {
			log.info("Error in Room record retrieval");
			throw e;
		}
		return room;
	}
	
	
}

package com.myclinic.rest;

import java.net.URI;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myclinic.model.Room;
import com.myclinic.service.IRoomService;
import com.myclinic.service.dto.insertion.RoomInsertDTO;
import com.myclinic.service.dto.readonly.RoomReadOnlyDTO;
import com.myclinic.service.dto.update.RoomUpdateDTO;
import com.myclinic.service.exceptions.EntityNotFoundException;
import com.myclinic.service.util.mapper.RoomMapper;
import com.myclinic.service.util.validation.insertion.RoomInsertValidator;
import com.myclinic.service.util.validation.update.RoomUpdateValidator;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class RoomRestController {
	
	private final IRoomService roomService;
	private final RoomInsertValidator roomInsertValidator;
	private final RoomUpdateValidator roomUpdateValidator;
	
	@Autowired
	public RoomRestController(IRoomService roomService, RoomInsertValidator roomInsertValidator,
			RoomUpdateValidator roomUpdateValidator) {
		this.roomService = roomService;
		this.roomInsertValidator = roomInsertValidator;
		this.roomUpdateValidator = roomUpdateValidator;
	}
	
	@PostMapping("/rooms")
	public ResponseEntity<RoomReadOnlyDTO> addRoom(@Valid @RequestBody RoomInsertDTO dto, BindingResult bindingResult) {
		
		roomInsertValidator.validate(dto, bindingResult);
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			Room room = roomService.insertRoom(dto);
			RoomReadOnlyDTO roomDTO = RoomMapper.mapToReadOnlyDTO(room);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(roomDTO.getId()).toUri();
			return ResponseEntity.created(location).body(roomDTO);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@PutMapping("/rooms/{roomId}")
	public ResponseEntity<RoomReadOnlyDTO> updateRoom(@PathVariable("roomId") Long roomId, @Valid @RequestBody RoomUpdateDTO dto,
			BindingResult bindingResult) {
		
		if(!Objects.equals(roomId, dto.getId())) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); 
		roomUpdateValidator.validate(dto, bindingResult);
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			Room room = roomService.updateRoom(dto);
			RoomReadOnlyDTO roomReadOnlyDTO = RoomMapper.mapToReadOnlyDTO(room);
			return new ResponseEntity<>(roomReadOnlyDTO, HttpStatus.OK);
		} catch(EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/rooms/{roomId}")
	public ResponseEntity<RoomReadOnlyDTO> deleteRoom(@PathVariable("roomId") Long roomId) {
		try {
			Room room = roomService.getRoomById(roomId);
			roomService.deleteRoom(roomId);
			RoomReadOnlyDTO roomDTO = RoomMapper.mapToReadOnlyDTO(room);
			return new ResponseEntity<>(roomDTO, HttpStatus.OK);
		} catch (EntityNotFoundException | NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

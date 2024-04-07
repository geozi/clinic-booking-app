package com.myclinic.service.dto.update;

import com.myclinic.model.Room;
import com.myclinic.service.dto.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The {@link RoomUpdateDTO} class is the DTO equivalent of the
 * {@link Room} class, adjusted for updating operations.
 * It inherits from the {@link BaseDTO} class.
 */
@NoArgsConstructor
@Getter
@Setter
public class RoomUpdateDTO extends BaseDTO {

	private String number;
	private Integer capacity;
	
	public RoomUpdateDTO(Long id, String number, Integer capacity) {
		this.setId(id);
		this.number = number;
		this.capacity = capacity;
	}
	
	

}

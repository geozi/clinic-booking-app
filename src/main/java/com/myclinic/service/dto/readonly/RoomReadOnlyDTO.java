package com.myclinic.service.dto.readonly;

import com.myclinic.model.Room;
import com.myclinic.service.dto.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The {@link RoomReadOnlyDTO} class is the DTO equivalent of the
 * {@link Room} class, adjusted for read-only operations.
 * It inherits from the {@link BaseDTO} class.
 */
@NoArgsConstructor
@Getter
@Setter
public class RoomReadOnlyDTO extends BaseDTO {

	private String number;
	private Integer capacity;
	
	public RoomReadOnlyDTO(Long id, String number, Integer capacity) {
		super.setId(id);;
		this.number = number;
		this.capacity = capacity;
	}
	
	

}

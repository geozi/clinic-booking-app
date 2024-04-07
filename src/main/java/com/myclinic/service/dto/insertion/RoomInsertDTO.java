package com.myclinic.service.dto.insertion;

import com.myclinic.model.Room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * The {@link RoomInsertDTO} class is the DTO equivalent
 * of the {@link Room} class, adjusted for inserting
 * operations.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoomInsertDTO {

	private String number;
	private Integer capacity;

}

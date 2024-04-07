package com.myclinic.service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The {@link BaseDTO} class enables subtype polymorphism for
 * DTO implementations.
 */
@NoArgsConstructor 
@Getter
@Setter
public abstract class BaseDTO {
	@NotNull
	private Long id;

}

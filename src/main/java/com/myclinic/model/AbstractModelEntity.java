package com.myclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * The {@link AbstractModelEntity} class is the super-class of
 * all domain model classes, offering common functionality.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class AbstractModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long id;

}

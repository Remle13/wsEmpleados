package com.upax.empleados.model.response;

import java.time.LocalDate;

import com.upax.empleados.entity.GenderEntity;
import com.upax.empleados.entity.JobEntity;

import lombok.*;

/**
 * Respuesta de la API de employees.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 20/01/22
 */

@Getter
@Setter
@ToString
public class EmployeeResponse {
	
	  /** Identificador del empleado. */
	  private Long id;
	  /** Identificador del genero. */
	  private GenderEntity gender;
	  /** Identificador del puesto. */
	  private JobEntity job;
	  /** Nombre del empleado. */
	  private String name;
	  /** Apellido del empleado. */
	  private String last_name;
	  /** Fecha de nacimiento del empleado. */
	  private LocalDate birthdate;

}



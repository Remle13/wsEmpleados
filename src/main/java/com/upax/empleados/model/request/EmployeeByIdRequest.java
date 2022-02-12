package com.upax.empleados.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objeto de entrada de la API de Consulta de empleados por id.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 22/01/22
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeByIdRequest {
	
	/** Lista de ids de empleados */
	@JsonProperty("employee_id")
	private Long employeeId;

	/** Fecha inicio. */
	@JsonProperty("start_date")
	private LocalDate startDate;

	/** Fecha final. */
	@JsonProperty("end_date")
	private LocalDate endDate;
	
}

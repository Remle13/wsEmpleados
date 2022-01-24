package com.upax.empleados.model.request;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
	private List<Long> ids;

	/** Fecha inicio. */
	@JsonProperty("start_date")
	private LocalDate startDate;

	/** Fecha final. */
	@JsonProperty("end_date")
	private LocalDate endDate;
	
}

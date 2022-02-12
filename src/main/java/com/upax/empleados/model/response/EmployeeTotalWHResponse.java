package com.upax.empleados.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * Respuesta de la API de employees.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 21/01/22
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeTotalWHResponse {
	
	  /** Total de horas trabajadas. */
	  private Integer total_worked_hours;
	  /** Estatus de la respuesta. */
	  @Builder.Default Boolean success = false;

}



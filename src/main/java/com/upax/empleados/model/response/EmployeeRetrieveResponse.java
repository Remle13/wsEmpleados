package com.upax.empleados.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;

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
public class EmployeeRetrieveResponse {
	
	  /** Listado de empleados. */
	  List<EmployeeResponse> employees;
	  /** Estatus de la respuesta. */
	  @Builder.Default Boolean success = false;

}



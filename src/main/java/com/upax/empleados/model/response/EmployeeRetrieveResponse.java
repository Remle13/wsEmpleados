package com.upax.empleados.model.response;

import lombok.*;

import java.util.List;
import java.util.Map;


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



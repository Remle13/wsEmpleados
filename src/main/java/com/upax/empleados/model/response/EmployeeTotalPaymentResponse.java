package com.upax.empleados.model.response;

import lombok.*;


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
public class EmployeeTotalPaymentResponse {
	
	  /** Total de horas trabajadas. */
	  private Double payment;
	  /** Estatus de la respuesta. */
	  @Builder.Default Boolean success = false;

}



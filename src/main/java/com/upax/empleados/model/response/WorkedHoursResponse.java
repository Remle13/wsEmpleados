package com.upax.empleados.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * Respuesta de la API de horas trabjadas.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 11/02/22
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WorkedHoursResponse {
	
	  /** Identificador de las horas trabajadas. */
	  private Long id;
	  /** Estatus de la respuesta. */
	  @Builder.Default Boolean success = false;

}



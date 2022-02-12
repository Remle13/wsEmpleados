package com.upax.empleados.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objeto de entrada de la API de Consulta de empleados por id del puesto.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 21/01/22
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeByJobIdRequest {
  /** Identificador del puesto. */
  @NotNull
  @Min(value = 1)
  @JsonProperty("job_id")
  private Long jobId;
}

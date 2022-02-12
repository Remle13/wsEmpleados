package com.upax.empleados.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objeto de entrada de la API de Registro de empleados.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 20/01/22
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeRequest {
  /** Identificador del empleado. */
  private Long id;
  /** Identificador del genero. */
  @NotNull
  @Min(value = 1)
  @JsonProperty("gender_id")
  private Long genderId;
  /** Identificador del puesto. */
  @NotNull
  @Min(value = 1)
  @JsonProperty("job_id")
  private Long jobId;
  /** Nombre del empleado. */
  @NotBlank
  private String name;
  /** Apellido del empleado. */
  @NotBlank
  private String last_name;
  /** Fecha de nacimiento del empleado. */
  private LocalDate birthdate;
}

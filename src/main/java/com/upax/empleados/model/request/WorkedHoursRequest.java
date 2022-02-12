package com.upax.empleados.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Objeto de entrada de la API de Registro de las horas trabajadas del empleado.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 11/02/22
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WorkedHoursRequest {
  /** Identificador del registro de horas trabajadas. */
  private Long id;
  /** Identificador del empleado. */
  @NotNull
  @Min(value = 1)
  @JsonProperty("employee_id")
  private Long EmployeeId;
  /** Horas trabajadas. */
  @NotNull
  @Min(value = 1)
  @Max(value = 20)
  @JsonProperty("worked_hours")
  private Long workedHours;
  /** Fecha trabajada del empleado. */
  @NotNull
  @JsonProperty("worked_date")
  private LocalDate workedDate;
}

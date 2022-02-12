package com.upax.empleados.entity;

import com.upax.empleados.constant.DatabaseConstant;
import lombok.*;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Max;

import java.time.LocalDate;
import java.util.Set;

/**
 * Entidad para la tabla employees.
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
@Entity(name = DatabaseConstant.TABLE_WORKED_HOURS)
@Table(name = DatabaseConstant.TABLE_WORKED_HOURS)
public class WorkedHoursEntity {
	
  /** Identificador de las horas trabajadas. */
  @Id
  @Column(name = DatabaseConstant.PROPERTY_WORKED_HOURS_ID)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  /** Identificador del empleado. */
  @ManyToOne
  @JoinColumn(name = DatabaseConstant.PROPERTY_WORKED_HOURS_EMPLOYEE_ID)
  private EmployeeEntity employee;

  /** Horas trabajadas del empleado. */
  @Column(name = DatabaseConstant.PROPERTY_WORKED_HOURS_WORKED_HOURS)
  private Integer workedHours;
  
  /** Fecha trabajada del empleado */
  @LastModifiedDate
  @Column(name = DatabaseConstant.PROPERTY_WORKED_HOURS_WORKED_DATE)
  private LocalDate workedDate;

}

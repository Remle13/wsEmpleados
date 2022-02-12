package com.upax.empleados.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.LastModifiedDate;

import com.upax.empleados.constant.DatabaseConstant;

import java.time.LocalDate;

import javax.persistence.*;

/**
 * Entidad para la tabla employees.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 20/01/22
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = DatabaseConstant.TABLE_EMPLOYEES)
@Table(name = DatabaseConstant.TABLE_EMPLOYEES)
public class EmployeeEntity{
	
  /** Identificador del empleado. */
  @Id
  @Column(name = DatabaseConstant.PROPERTY_EMPLOYEE_ID)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  /** Identificador del genero del empleado. */
  @ManyToOne
  @JoinColumn(name = DatabaseConstant.PROPERTY_EMPLOYEE_GENDER_ID)
  private GenderEntity gender;
  
  /** Identificador del puesto del empleado. */
  @ManyToOne
  @JoinColumn(name = DatabaseConstant.PROPERTY_EMPLOYEE_JOB_ID)
  private JobEntity job;
  
  /** Nombre del empleado. */
  @Column(
      name = DatabaseConstant.PROPERTY_EMPLOYEE_NAME,
      nullable = false,
      length = 255,
      unique = true)
  @NaturalId(mutable = true)
  private String name;
  
  /** Apellido del empleado. */
  @Column(
      name = DatabaseConstant.PROPERTY_EMPLOYEE_LAST_NAME,
      nullable = false,
      length = 255,
      unique = true)
  @NaturalId(mutable = true)
  private String last_name;
  
  /** Fecha de Nacimiento del empleado */
  @LastModifiedDate
  @Column(name = DatabaseConstant.PROPERTY_EMPLOYEE_BIRTHDATE)
  private LocalDate birthdate;

}

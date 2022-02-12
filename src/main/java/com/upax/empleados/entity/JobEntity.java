package com.upax.empleados.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import com.upax.empleados.constant.DatabaseConstant;

import javax.persistence.*;

/**
 * Entidad para la tabla jobs.
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
@Entity(name = DatabaseConstant.TABLE_JOBS)
@Table(name = DatabaseConstant.TABLE_JOBS)
public class JobEntity{

  /** Identificador del puesto. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = DatabaseConstant.PROPERTY_JOB_ID)
  private Long id;
  
  /** Nombre del empleado. */
  @Column(
	  name = DatabaseConstant.PROPERTY_JOB_NAME,
      nullable = false,
      length = 255,
      unique = true)
  @NaturalId(mutable = true)
  private String name;
  
  /** Costo de envio. */
  @Column(
	  name = DatabaseConstant.PROPERTY_JOB_SALARY,
	  nullable = false)
  private double salary;

}

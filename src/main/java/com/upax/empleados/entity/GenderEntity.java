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
 * Entidad para la tabla genders.
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
@Entity(name = DatabaseConstant.TABLE_GENDERS)
@Table(name = DatabaseConstant.TABLE_GENDERS)
public class GenderEntity{

  /** Identificador del genero. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = DatabaseConstant.PROPERTY_GENDER_ID)
  private Long id;
  
  /** Nombre del genero. */
  @Column(
	  name = DatabaseConstant.PROPERTY_GENDER_NAME,
      nullable = false,
      length = 255,
      unique = true)
  @NaturalId(mutable = true)
  private String name;

}

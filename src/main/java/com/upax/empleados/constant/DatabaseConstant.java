package com.upax.empleados.constant;

/**
 * Constantes para base de datos.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 21/01/22
 */
public class DatabaseConstant {
  /** Nombre de la tabla empleados. */
  public static final String TABLE_EMPLOYEES = "employees";
  /** Propiedad para el identificador del empleado. */
  public static final String PROPERTY_EMPLOYEE_ID = "id";
  /** Propiedad para el identificador del genero del empleado. */
  public static final String PROPERTY_EMPLOYEE_GENDER_ID = "gender_id";
  /** Propiedad para el identificador del puesto del empleado. */
  public static final String PROPERTY_EMPLOYEE_JOB_ID = "job_id";
  /** Propiedad para el nombre del empleado. */
  public static final String PROPERTY_EMPLOYEE_NAME = "name";
  /** Propiedad para el apellido del empleado. */
  public static final String PROPERTY_EMPLOYEE_LAST_NAME = "last_name";
  /** Propiedad para la fecha de nacimiento del empleado */
  public static final String PROPERTY_EMPLOYEE_BIRTHDATE = "birthdate";
  
  /** Nombre de la tabla generos. */
  public static final String TABLE_GENDERS = "genders";
  /** Propiedad para el identificador del genero. */
  public static final String PROPERTY_GENDER_ID = "id";
  /** Propiedad para el nombre del genero. */
  public static final String PROPERTY_GENDER_NAME = "name";
  
  /** Nombre de la tabla puestos. */
  public static final String TABLE_JOBS = "jobs";
  /** Propiedad para el identificador del puesto. */
  public static final String PROPERTY_JOB_ID = "id";
  /** Propiedad para el nombre del puesto. */
  public static final String PROPERTY_JOB_NAME = "name";
  /** Propiedad para el salario del puesto. */
  public static final String PROPERTY_JOB_SALARY = "salary";
  

  /** Constructor privado. */
  private DatabaseConstant() {}
}

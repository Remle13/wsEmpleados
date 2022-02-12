package com.upax.empleados.constant;

/**
 * Constantes de rutas.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 20/01/22
 */
public class RoutesConstant {
  /** Ruta base del proyecto. */
  public static final String BASE_PATH = "${api.uri.basePath}";
  /** Ruta para el registro de un empleado. */
  public static final String EMPLOYEE_SAVE_PATH = "${api.uri.employees.save.mapping}";
  /** Ruta para el registro de un empleado. */
  public static final String EMPLOYEE_SAVE_WH_PATH = "${api.uri.employees.save.workedhours.mapping}";
  /** Ruta para la consulta de los empleados por puesto. */
  public static final String EMPLOYEE_RETRIEVE_JOB_PATH = "${api.uri.employees.retrieve.job.mapping}";
  /** Ruta para la consulta de los empleados por id del empleado. */
  public static final String EMPLOYEE_RETRIEVE_TOTAL_WH = "${api.uri.employees.retrieve.total.workedhours.mapping}";
  /** Ruta para la consulta de los empleados por id del empleado. */
  public static final String EMPLOYEE_RETRIEVE_TOTAL_PAYMENT = "${api.uri.employees.retrieve.total.payment.mapping}";

  /** Constructor de la clase. */
  private RoutesConstant() {}
}

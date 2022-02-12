package com.upax.empleados.constant;

/**
 * Consultas estáticas.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 11/02/22
 */
public class QueryConstant {
  /**
   * Consulta usuario por:
   *
   * <ul>
   *   <li>Empleado Id
   * </ul>
   */
  public static final String FIND_EMPLOYEE_WH_BY =
      "SELECT e.id, e.employee_id, e.worked_hours, e.worked_date "
          + "FROM employee_worked_hours e "
          + "WHERE e.employee_id = :employee_id "
          + "AND e.worked_date >= :startDate "
          + "AND e.worked_date <= :endDate ";

  /** constructor privado. */
  private QueryConstant() {}
}

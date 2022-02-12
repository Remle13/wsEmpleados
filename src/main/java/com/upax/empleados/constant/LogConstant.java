package com.upax.empleados.constant;

/**
 * Constantes para log.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 11/02/22
 */
public abstract class LogConstant {
	
	/** Registra un empleado. */
	public static final String EMPLOYEE_SAVE_REQUEST = "Empleado a registrar {}";

	/** Respuesta del registro de empleado */
	public static final String EMPLOYEE_SAVE_RESPONSE = "Empleado registrado {}";

	/** Log por si el empleado es menor de edad */
	public static final String EMPLOYEE_YOUNGER = "El empleado {} es menor de edad";

	/** Registra horas trabajadas */
	public static final String WORKED_HOURS_REQUEST = "Horas trabajadas a registrar {}";

	/** Respuesta del registro de las horas registradas */
	public static final String WORKED_HOURS_RESPONSE = "Horas trabajadas registradas {}";

	/** Log para cuando la fecha trabajada es mayor a la actual */
	public static final String WORKED_HOURS_DATE_ERROR = "La fecha trabajada es mayor a la fecha actual";

	/** Consulta empleados por el id del puesto. */
	public static final String EMPLOYEE_FILTER_JOB_REQUEST = "Consulta empleados por el id del puesto {}";

	/** Respuesta de la consulta cd empleados por el id del puesto. */
	public static final String EMPLOYEE_FILTER_JOB_RESPONSE = "Empleados consultados por el id del puesto: {}";

	/** Consulta las horas totales trabajadas por el empleado id. */
	public static final String EMPLOYEE_TOTAL_WH_REQUEST = "Horas trabajadas a registrar {}";

	/** Respuesta de la consulta las horas totales trabajadas por el empleado id. */
	public static final String EMPLOYEE_TOTAL_WH_RESPONSE = "Total horas trabajadas: {}";

	/** Log para cuando la fecha inicio sea mayor o igual a la fecha fin */
	public static final String EMPLOYEE_TOTAL_WH_DATE_ERROR = "La fecha de inicio es mayor o igual a la fecha final";

	/** Error generico. */
	public static final String EMPLOYEE_ERROR_GENERIC_WHERE = "Error -> {}";
	public static final String EMPLOYEE_ERROR_GENERIC = "Error -> Ocurrió un error durante su solicitud, Mensaje: {}";

}

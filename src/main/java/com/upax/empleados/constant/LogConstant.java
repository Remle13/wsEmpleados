package com.upax.empleados.constant;

/**
 * Constantes para log.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 21/01/22
 */
public abstract class LogConstant {
	
	/** Registra un empleado. */
	public static final String EMPLOYEE_SAVE_REQUEST = "Empleado a registrar {}";

	/** Respuesta del registro de empleado */
	public static final String EMPLOYEE_SAVE_RESPONSE = "Empleado registrado {}";

	/** Consulta empleados por el id del puesto. */
	public static final String EMPLOYEE_FILTER_JOB_REQUEST = "Consulta empleados por el id del puesto {}";

	/** Respuesta de la consulta cd empleados por el id del puesto. */
	public static final String EMPLOYEE_FILTER_JOB_RESPONSE = "Empleados consultados por el id del puesto: {}";

	/** Consulta empleados por su id. */
	public static final String EMPLOYEE_FILTER_ID_REQUEST = "Consulta empleados por su id {}";

	/** Respuesta de la consulta de empleados por su id. */
	public static final String EMPLOYEE_FILTER_ID_RESPONSE = "Empleados consultados por su id: {}";

	/** Error generico. */
	public static final String EMPLOYEE_ERROR_GENERIC_WHERE = "Error -> {}";
	public static final String EMPLOYEE_ERROR_GENERIC = "Error -> Ocurrió un error durante su solicitud, Mensaje: {}";

}

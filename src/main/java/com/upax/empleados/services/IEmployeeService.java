package com.upax.empleados.services;

import com.upax.empleados.model.request.EmployeeByIdRequest;
import com.upax.empleados.model.request.EmployeeByJobIdRequest;
import com.upax.empleados.model.request.EmployeeRequest;
import com.upax.empleados.model.request.WorkedHoursRequest;
import com.upax.empleados.model.response.*;

/**
 * Reglas de negocio de Employees
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 11/02/22
 */

public interface IEmployeeService {
	
	/*
	 * Registra un empleado.
	 *
	 * @param request datos del empleado {@link EmployeeRequest}
	 */
	public EmployeeSaveResponse save(EmployeeRequest request);

	/*
	 * Registra horas trabjadas del dia.
	 *
	 * @param request datos de las horas trabajadas {@link WorkedHoursRequest}
	 */
	public WorkedHoursResponse saveWH(WorkedHoursRequest request);
	
	/**
	 * Consulta todos los empleados por puesto.
	 *
	 * @return lista de todas los empleados por puesto
	 */
	EmployeeRetrieveResponse getEmployeesByJobId(EmployeeByJobIdRequest request);

	/**
	 * Consulta las horas trabajadas de un empleado.
	 *
	 * @return total de horas trabajadas
	 */
	EmployeeTotalWHResponse getTotalWHById(EmployeeByIdRequest request);

	/**
	 * Consulta las horas trabajadas por el salario por hora del empleado.
	 *
	 * @return total de horas trabajadas por el salario por hora del empleado
	 */
	EmployeeTotalPaymentResponse getTotalPaymentById(EmployeeByIdRequest request);

}

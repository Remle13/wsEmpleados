package com.upax.empleados.services;

import com.upax.empleados.model.request.EmployeeByIdRequest;
import com.upax.empleados.model.request.EmployeeByJobIdRequest;
import com.upax.empleados.model.request.EmployeeRequest;
import com.upax.empleados.model.response.EmployeeRetrieveResponse;
import com.upax.empleados.model.response.EmployeeSaveResponse;

/**
 * Reglas de negocio de Employees
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 20/01/22
 */

public interface IEmployeeService {
	
	/*
	 * Registra un empleado.
	 *
	 * @param request datos del empleado {@link EmployeeRequest}
	 */
	public EmployeeSaveResponse save(EmployeeRequest request);
	
	/**
	 * Consulta todos los empleados por puesto.
	 *
	 * @return lista de todas los empleados por puesto
	 */
	EmployeeRetrieveResponse getEmployeesByJobId(EmployeeByJobIdRequest request);
	
	/**
	 * Consulta todos los empleados por id.
	 *
	 * @return lista de todas las empleados por id
	 */
	EmployeeRetrieveResponse getEmployeesById(EmployeeByIdRequest request);

}

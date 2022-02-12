package com.upax.empleados.api;

import com.upax.empleados.model.request.WorkedHoursRequest;
import com.upax.empleados.model.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upax.empleados.constant.RoutesConstant;
import com.upax.empleados.model.request.EmployeeByIdRequest;
import com.upax.empleados.model.request.EmployeeByJobIdRequest;
import com.upax.empleados.model.request.EmployeeRequest;
import com.upax.empleados.services.IEmployeeService;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;

/**
 * APIS de empleados.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 20/01/22
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = RoutesConstant.BASE_PATH)
public class EmployeesController {

	@Autowired
	private IEmployeeService employeeService;

	@PostMapping(path = RoutesConstant.EMPLOYEE_SAVE_PATH, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeSaveResponse> save(@RequestBody @Valid EmployeeRequest request) {
		return new ResponseEntity<EmployeeSaveResponse>(this.employeeService.save(request), HttpStatus.CREATED);
	}

	@PostMapping(path = RoutesConstant.EMPLOYEE_SAVE_WH_PATH,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WorkedHoursResponse> saveWorkedHours(@RequestBody @Valid WorkedHoursRequest request) {
		return new ResponseEntity<WorkedHoursResponse>(this.employeeService.saveWH(request), HttpStatus.CREATED);
	}

	@PostMapping(path = RoutesConstant.EMPLOYEE_RETRIEVE_JOB_PATH,
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeRetrieveResponse> getEmployeesByIdJob(@RequestBody @Valid EmployeeByJobIdRequest request) {
		return ResponseEntity.ok(this.employeeService.getEmployeesByJobId(request));
	}

	@PostMapping(path= RoutesConstant.EMPLOYEE_RETRIEVE_TOTAL_WH,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeTotalWHResponse> getTotalWHById(@RequestBody @Valid EmployeeByIdRequest request) {
		return ResponseEntity.ok(this.employeeService.getTotalWHById(request));
	}

	@PostMapping(path = RoutesConstant.EMPLOYEE_RETRIEVE_TOTAL_PAYMENT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeTotalPaymentResponse> getTotalPaymentById(@RequestBody @Valid EmployeeByIdRequest request) {
		return ResponseEntity.ok(this.employeeService.getTotalPaymentById(request));
	}

}

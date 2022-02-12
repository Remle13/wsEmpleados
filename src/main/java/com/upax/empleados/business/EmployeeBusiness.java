package com.upax.empleados.business;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import com.upax.empleados.model.request.EmployeeByIdRequest;
import com.upax.empleados.model.request.WorkedHoursRequest;
import com.upax.empleados.model.response.*;
import com.upax.empleados.repository.IWorkedHoursRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upax.empleados.constant.LogConstant;
import com.upax.empleados.entity.EmployeeEntity;
import com.upax.empleados.entity.WorkedHoursEntity;
import com.upax.empleados.model.request.EmployeeByJobIdRequest;
import com.upax.empleados.model.request.EmployeeRequest;
import com.upax.empleados.repository.IEmployeeRepository;
import com.upax.empleados.services.IEmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementación de las reglas de negocio de los empleados
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 20/01/22
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeBusiness implements IEmployeeService {
	
	/** Repositorio de Empleados. */
	@Autowired
	private final IEmployeeRepository employeeRepository;

	/** Repositorio de Horas trabajadas. */
	@Autowired
	private final IWorkedHoursRepository workedHoursRepository;

	/** {@inheritDoc}. */
	@Override
	public EmployeeSaveResponse save(EmployeeRequest request) {
		log.info(LogConstant.EMPLOYEE_SAVE_REQUEST, request);

		EmployeeSaveResponse response = new EmployeeSaveResponse();
		
		try {
			int edad = Period.between(request.getBirthdate(), LocalDate.now()).getYears();
		
			if (edad >= 18) {
				EmployeeEntity entity = this.employeeRepository.save(this.mapping(request));

				response.setId(entity.getId());
				response.setSuccess(true);

				log.info(LogConstant.EMPLOYEE_SAVE_RESPONSE, response);
			}else{
				log.info(LogConstant.EMPLOYEE_YOUNGER, request.getName() + request.getLast_name());
			}
		} catch (Exception e) {
			log.error(LogConstant.EMPLOYEE_ERROR_GENERIC_WHERE, e.getStackTrace());
			log.error(LogConstant.EMPLOYEE_ERROR_GENERIC, e.getMessage());
		}

		return response;
	}

	@Override
	public WorkedHoursResponse saveWH(WorkedHoursRequest request) {
		log.info(LogConstant.WORKED_HOURS_REQUEST, request);

		WorkedHoursResponse response = new WorkedHoursResponse();

		try{
			if (request.getWorkedDate().isBefore(LocalDate.now()) || request.getWorkedDate().isEqual(LocalDate.now())) {
				WorkedHoursEntity entity = this.workedHoursRepository.save(this.mappingWH(request));

				response.setId(entity.getId());
				response.setSuccess(true);

				log.info(LogConstant.WORKED_HOURS_RESPONSE, response);
			}else{
				log.info(LogConstant.WORKED_HOURS_DATE_ERROR);
			}
		} catch (Exception e) {
			log.error(LogConstant.EMPLOYEE_ERROR_GENERIC_WHERE, e.getStackTrace());
			log.error(LogConstant.EMPLOYEE_ERROR_GENERIC, e.getMessage());
		}

		return response;
	}

	@Override
	public EmployeeRetrieveResponse getEmployeesByJobId(EmployeeByJobIdRequest jobIdRequest) {
		log.info(LogConstant.EMPLOYEE_FILTER_JOB_REQUEST, jobIdRequest);

		EmployeeRetrieveResponse response = new EmployeeRetrieveResponse();
		
		try{
			List<EmployeeResponse> employees = this.employeeRepository.findAllByJobId(jobIdRequest.getJobId())
					.stream()
					.map(this::mapping)
					.collect(Collectors.toList());

			response.setEmployees(employees);
			response.setSuccess(true);

			log.info(LogConstant.EMPLOYEE_FILTER_JOB_RESPONSE, response);

		}catch(Exception e) {
			log.error(LogConstant.EMPLOYEE_ERROR_GENERIC_WHERE, e.getStackTrace());
			log.error(LogConstant.EMPLOYEE_ERROR_GENERIC, e.getMessage());
		}
			
	    return response;
	}

	@Override
	public EmployeeTotalWHResponse getTotalWHById(EmployeeByIdRequest request) {
		log.info(LogConstant.EMPLOYEE_TOTAL_WH_REQUEST, request);

		EmployeeTotalWHResponse response = new EmployeeTotalWHResponse();

		try{
			if (request.getStartDate().isBefore(request.getEndDate())) {
				Integer totalWorkedHours = this.workedHoursRepository.findByIdEmployee(
								request.getEmployeeId(), request.getStartDate(), request.getEndDate())
						.stream().reduce(0, (sum, wh) -> sum + wh.getWorkedHours(), Integer::sum);

				response.setTotal_worked_hours(totalWorkedHours);
				response.setSuccess(true);

				log.info(LogConstant.EMPLOYEE_TOTAL_WH_RESPONSE, response);
			}else{
				log.info(LogConstant.EMPLOYEE_TOTAL_WH_DATE_ERROR);
			}

		}catch(Exception e) {
			log.error(LogConstant.EMPLOYEE_ERROR_GENERIC_WHERE, e.getStackTrace());
			log.error(LogConstant.EMPLOYEE_ERROR_GENERIC, e.getMessage());
		}

		return response;
	}

	@Override
	public EmployeeTotalPaymentResponse getTotalPaymentById(EmployeeByIdRequest request) {
		log.info(LogConstant.EMPLOYEE_TOTAL_WH_REQUEST, request);

		EmployeeTotalPaymentResponse response = new EmployeeTotalPaymentResponse();

		try{
			if (request.getStartDate().isBefore(request.getEndDate())) {
				Integer totalWorkedHours = this.workedHoursRepository.findByIdEmployee(
								request.getEmployeeId(), request.getStartDate(), request.getEndDate())
						.stream().reduce(0, (sum, wh) -> sum + wh.getWorkedHours(), Integer::sum);

				Double salaryEmployee =	this.employeeRepository.findById(request.getEmployeeId()).get().getJob().getSalary();

				Double salaryTotal = totalWorkedHours * salaryEmployee;

				response.setPayment(salaryTotal);
				response.setSuccess(true);

				log.info(LogConstant.EMPLOYEE_TOTAL_WH_RESPONSE, response);
			}else{
				log.info(LogConstant.EMPLOYEE_TOTAL_WH_DATE_ERROR);
			}

		}catch(Exception e) {
			log.error(LogConstant.EMPLOYEE_ERROR_GENERIC_WHERE, e.getStackTrace());
			log.error(LogConstant.EMPLOYEE_ERROR_GENERIC, e.getMessage());
		}

		return response;
	}


	/**
	 * Convierte un objeto {@link EmployeeRequest} a un entity de tipo {@link EmployeeEntity}
	 *
	 * @param request petición con los datos del empleado
	 * @return {@link EmployeeEntity} entidad de empleados
	 */
	private EmployeeEntity mapping(EmployeeRequest request) {
		return new ModelMapper().map(request, EmployeeEntity.class);
	}

	/**
	 * Convierte un entity de tipo {@link EmployeeEntity} a un objeto {@link EmployeeResponse}
	 *
	 * @param entity entidad de empleados
	 * @return {@link EmployeeResponse} respuesta de la API de consulta de empleados
	 */
	private EmployeeResponse mapping(EmployeeEntity entity) {
		return new ModelMapper().map(entity, EmployeeResponse.class);
	}

	/**
	 * Convierte un objeto {@link WorkedHoursRequest} a un entity de tipo {@link WorkedHoursEntity}
	 *
	 * @param request petición con los datos de las horas trabajadas
	 * @return {@link WorkedHoursEntity} entidad de las horas trabajadas
	 */
	private WorkedHoursEntity mappingWH(WorkedHoursRequest request) {
		return new ModelMapper().map(request, WorkedHoursEntity.class);
	}

}

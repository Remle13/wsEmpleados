package com.upax.empleados.business;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import com.upax.empleados.model.response.EmployeeRetrieveResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.upax.empleados.constant.LogConstant;
import com.upax.empleados.entity.EmployeeEntity;
import com.upax.empleados.model.request.EmployeeByIdRequest;
import com.upax.empleados.model.request.EmployeeByJobIdRequest;
import com.upax.empleados.model.request.EmployeeRequest;
import com.upax.empleados.model.response.EmployeeResponse;
import com.upax.empleados.model.response.EmployeeSaveResponse;
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
			List<EmployeeResponse> employees = this.employeeRepository.findAll().stream()
					.filter(e -> e.getJob().getId().equals(jobIdRequest.getJobId()))
					.map(this::mapping)
					.sorted((a, b) -> (a.getLast_name().toLowerCase()).compareTo(b.getLast_name().toLowerCase()))
					.collect(Collectors.toList());

			/** Agrupamietos por Apellido */
			Map<String, List<EmployeeResponse>> byLastName =
					employees.stream().collect(Collectors.groupingBy(EmployeeResponse::getLast_name));

			for (Map.Entry<String, List<EmployeeResponse>> e : byLastName.entrySet()) {
				String key = e.getKey();
				List<EmployeeResponse> value = e.getValue();
				log.info("Agrupamieto por {}, Empleados({}): {}", key, value.size(), value);
			}
			/** Fin Agrupamietos por Apellido */

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
	public EmployeeRetrieveResponse getEmployeesById(EmployeeByIdRequest request) {
		log.info(LogConstant.EMPLOYEE_FILTER_ID_REQUEST, request);

	    return getEmployees(request);
	}
	
	@Async
	public EmployeeRetrieveResponse getEmployees(EmployeeByIdRequest request) {

		EmployeeRetrieveResponse response = new EmployeeRetrieveResponse();
		
		try{
			List<EmployeeResponse> employees = new ArrayList<EmployeeResponse>();

			for (Long id : request.getIds()) {
				Optional<EmployeeEntity> entity = this.employeeRepository.findById(id);
				if (entity.isPresent()) {
					EmployeeResponse employee = this.mapping(entity.get());
					employees.add(employee);
				}
			}

			response.setEmployees(employees);
			response.setSuccess(true);

			log.info(LogConstant.EMPLOYEE_FILTER_ID_RESPONSE, response);

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

}

package com.upax.empleados.business;

import com.upax.empleados.constant.DatosConstant;
import com.upax.empleados.entity.WorkedHoursEntity;
import com.upax.empleados.model.request.EmployeeByIdRequest;
import com.upax.empleados.model.request.EmployeeRequest;
import com.upax.empleados.model.request.WorkedHoursRequest;
import com.upax.empleados.model.response.*;
import com.upax.empleados.repository.IWorkedHoursRepository;
import com.upax.empleados.services.IEmployeeService;
import org.junit.jupiter.api.Test;
import com.upax.empleados.entity.EmployeeEntity;
import com.upax.empleados.model.request.EmployeeByJobIdRequest;
import com.upax.empleados.repository.IEmployeeRepository;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias de la implementación de las reglas de negocio de los empleados
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 12/02/22
 */

@SpringBootTest
class EmployeeBusinessTest {

    @MockBean
    IEmployeeRepository repository;

    @MockBean
    IWorkedHoursRepository wHRepository;

    @Autowired
    IEmployeeService service;

    @Test
    void save() {
        EmployeeRequest request = DatosConstant.EXPLOREE_REQUEST;
        Mockito.when(repository.save(Mockito.any(EmployeeEntity.class))).then(new Answer<EmployeeEntity>(){

            Long idSec = 1L;

            @Override
            public EmployeeEntity answer(InvocationOnMock invocation) throws Throwable {
                EmployeeEntity entity = invocation.getArgument(0);
                entity.setId(idSec++);
                return entity;
            }
        });

        EmployeeSaveResponse response = service.save(request);

        assertTrue(response.getSuccess());
        assertEquals(1L,response.getId());
    }

    @Test
    void saveEdad() {
        EmployeeRequest request = DatosConstant.EXPLOREE_EDAD_REQUEST;
        Mockito.when(repository.save(Mockito.any(EmployeeEntity.class))).then(new Answer<EmployeeEntity>(){

            Long idSec = 1L;

            @Override
            public EmployeeEntity answer(InvocationOnMock invocation) throws Throwable {
                EmployeeEntity entity = invocation.getArgument(0);
                entity.setId(idSec++);
                return entity;
            }
        });

        EmployeeSaveResponse response = service.save(request);

        assertFalse(response.getSuccess());
    }

    @Test
    void saveThrow() {
        EmployeeRequest request = DatosConstant.EXPLOREE_REQUEST;

        Mockito.when(repository.save(Mockito.isNull())).thenThrow(NullPointerException.class);
        EmployeeSaveResponse response = service.save(request);

        assertFalse(response.getSuccess());
    }

    @Test
    void saveWH() {
        WorkedHoursRequest request = DatosConstant.EXPLOREE_WORKED_HOURS_REQUEST;
        Mockito.when(wHRepository.save(Mockito.any(WorkedHoursEntity.class))).then(new Answer<WorkedHoursEntity>(){

            Long idSec = 1L;

            @Override
            public WorkedHoursEntity answer(InvocationOnMock invocation) throws Throwable {
                WorkedHoursEntity entity = invocation.getArgument(0);
                entity.setId(idSec++);
                return entity;
            }
        });

        WorkedHoursResponse response = service.saveWH(request);

        assertTrue(response.getSuccess());
        assertEquals(1L,response.getId());
    }

    @Test
    void saveWHFecha() {
        WorkedHoursRequest request = DatosConstant.EXPLOREE_WORKED_HOURS_FECHA_REQUEST;
        Mockito.when(wHRepository.save(Mockito.any(WorkedHoursEntity.class))).then(new Answer<WorkedHoursEntity>(){

            Long idSec = 1L;

            @Override
            public WorkedHoursEntity answer(InvocationOnMock invocation) throws Throwable {
                WorkedHoursEntity entity = invocation.getArgument(0);
                entity.setId(idSec++);
                return entity;
            }
        });

        WorkedHoursResponse response = service.saveWH(request);

        assertFalse(response.getSuccess());
    }

    @Test
    void saveWHThrow() {
        WorkedHoursRequest request = DatosConstant.EXPLOREE_WORKED_HOURS_REQUEST;

        Mockito.when(wHRepository.save(Mockito.isNull())).thenThrow(NullPointerException.class);
        WorkedHoursResponse response = service.saveWH(request);

        assertFalse(response.getSuccess());
    }

    @Test
    void getEmployeesByJobId() {
        List<EmployeeEntity> employees = DatosConstant.EXPLOREES_ENTITIES;
        EmployeeByJobIdRequest request = new EmployeeByJobIdRequest();
        request.setJobId(1L);

        Mockito.when(repository.findAllByJobId(Mockito.any())).thenReturn(employees);
        EmployeeRetrieveResponse response = service.getEmployeesByJobId(request);

        assertTrue(response.getSuccess());
        assertEquals(request.getJobId(),response.getEmployees().get(0).getJob().getId());
        assertEquals(request.getJobId(),response.getEmployees().get(1).getJob().getId());
    }

    @Test
    void getEmployeesByIdJobThrow() {
        EmployeeByJobIdRequest request = null;

        Mockito.when(repository.findAll()).thenThrow(NullPointerException.class);
        EmployeeRetrieveResponse response = service.getEmployeesByJobId(request);

        assertFalse(response.getSuccess());
    }

    @Test
    void getTotalWHById() {
        List<WorkedHoursEntity> workedHours = DatosConstant.EXPLOREES_ID_ENTITIES;
        EmployeeByIdRequest request = DatosConstant.EXPLOREE_TOTAL_WORKED_HOURS_REQUEST;

        Mockito.when(wHRepository.findByIdEmployee(request.getEmployeeId(),request.getStartDate(),request.getEndDate())).thenReturn(workedHours);
        EmployeeTotalWHResponse response = service.getTotalWHById(request);

        assertTrue(response.getSuccess());
        assertEquals(14,response.getTotal_worked_hours());
    }

    @Test
    void getTotalWHByIdFecha() {
        List<WorkedHoursEntity> workedHours = DatosConstant.EXPLOREES_ID_ENTITIES;
        EmployeeByIdRequest request = DatosConstant.EXPLOREE_TOTAL_WORKED_HOURS_FECHA_REQUEST;

        Mockito.when(wHRepository.findByIdEmployee(request.getEmployeeId(),request.getStartDate(),request.getEndDate())).thenReturn(workedHours);
        EmployeeTotalWHResponse response = service.getTotalWHById(request);

        assertFalse(response.getSuccess());
    }

    @Test
    void getTotalWHByIdThrow() {
        EmployeeByIdRequest request = null;

        Mockito.when(wHRepository.findByIdEmployee(Mockito.anyLong(),Mockito.any(),Mockito.any())).thenThrow(NullPointerException.class);
        EmployeeTotalWHResponse response = service.getTotalWHById(request);

        assertFalse(response.getSuccess());
    }

    @Test
    void getTotalPaymentById() {
        List<WorkedHoursEntity> workedHours = DatosConstant.EXPLOREES_ID_ENTITIES;
        Optional<EmployeeEntity> employees = DatosConstant.O_EXPLOREES_PAYMENT_ENTITY;
        EmployeeByIdRequest request = DatosConstant.EXPLOREE_TOTAL_WORKED_HOURS_REQUEST;

        Mockito.when(wHRepository.findByIdEmployee(request.getEmployeeId(),request.getStartDate(),request.getEndDate())).thenReturn(workedHours);
        EmployeeTotalWHResponse response = service.getTotalWHById(request);

        Mockito.when(repository.findById(request.getEmployeeId())).thenReturn(employees);
        EmployeeTotalPaymentResponse resPayment = service.getTotalPaymentById(request);

        assertTrue(response.getSuccess());
        assertEquals(14,response.getTotal_worked_hours());
        assertEquals(6545,resPayment.getPayment());
    }

    @Test
    void getTotalPaymentByIdFecha() {
        List<WorkedHoursEntity> workedHours = DatosConstant.EXPLOREES_ID_ENTITIES;
        Optional<EmployeeEntity> employees = DatosConstant.O_EXPLOREES_PAYMENT_ENTITY;
        EmployeeByIdRequest request = DatosConstant.EXPLOREE_TOTAL_WORKED_HOURS_FECHA_REQUEST;

        Mockito.when(wHRepository.findByIdEmployee(request.getEmployeeId(),request.getStartDate(),request.getEndDate())).thenReturn(workedHours);
        EmployeeTotalWHResponse response = service.getTotalWHById(request);

        Mockito.when(repository.findById(request.getEmployeeId())).thenReturn(employees);
        EmployeeTotalPaymentResponse resPayment = service.getTotalPaymentById(request);

        assertFalse(response.getSuccess());
    }

    @Test
    void getTotalPaymentByIdThrow() {
        EmployeeByIdRequest request = null;

        Mockito.when(wHRepository.findByIdEmployee(Mockito.anyLong(),Mockito.any(),Mockito.any())).thenThrow(NullPointerException.class);
        EmployeeTotalPaymentResponse response = service.getTotalPaymentById(request);

        assertFalse(response.getSuccess());
    }
}
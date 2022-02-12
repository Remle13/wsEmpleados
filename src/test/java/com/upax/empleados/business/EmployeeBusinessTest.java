package com.upax.empleados.business;

import com.upax.empleados.constant.DatosConstant;
import com.upax.empleados.model.request.EmployeeRequest;
import com.upax.empleados.model.response.EmployeeRetrieveResponse;
import com.upax.empleados.model.response.EmployeeTotalWHResponse;
import com.upax.empleados.model.response.EmployeeSaveResponse;
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

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias de la implementación de las reglas de negocio de los empleados
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 22/01/22
 */

@SpringBootTest
class EmployeeBusinessTest {

    @MockBean
    IEmployeeRepository repository;

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
    void saveThrow() {
        EmployeeRequest request = DatosConstant.EXPLOREE_REQUEST;

        Mockito.when(repository.save(Mockito.isNull())).thenThrow(NullPointerException.class);
        EmployeeSaveResponse response = service.save(request);

        assertFalse(response.getSuccess());
    }

    @Test
    void getEmployeesByJobId() {
        List<EmployeeEntity> employees = DatosConstant.EXPLOREES_ENTITIES;
        EmployeeByJobIdRequest request = new EmployeeByJobIdRequest();
        request.setJobId(1L);

        Mockito.when(repository.findAll()).thenReturn(employees);
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
}
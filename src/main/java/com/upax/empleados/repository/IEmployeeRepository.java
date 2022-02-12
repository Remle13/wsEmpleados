package com.upax.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upax.empleados.entity.EmployeeEntity;

import java.util.List;

/**
 * Repositorio de Empleados.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 20/01/22
 */


@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, Long>{

    List<EmployeeEntity> findAllByJobId(Long job_id);

}

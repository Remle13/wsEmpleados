package com.upax.empleados.repository;

import com.upax.empleados.constant.QueryConstant;
import com.upax.empleados.entity.EmployeeEntity;
import com.upax.empleados.entity.WorkedHoursEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repositorio de Horas trabajadas.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 11/02/22
 */


@Repository
public interface IWorkedHoursRepository extends JpaRepository<WorkedHoursEntity, Long>{

    /**
     * Consulta horas trabajadas por:
     *
     * <ul>
     *   <li>Employee Id
     * </ul>
     *
     * @param employee_id parámetro de consulta
     * @return lista de horas trabajadas por empleado {@link EmployeeEntity}
     */
    @Query(nativeQuery = true, value = QueryConstant.FIND_EMPLOYEE_WH_BY)
    List<WorkedHoursEntity> findByIdEmployee(Long employee_id, LocalDate startDate, LocalDate endDate);

}

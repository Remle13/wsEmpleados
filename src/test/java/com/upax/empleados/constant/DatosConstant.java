package com.upax.empleados.constant;

import com.upax.empleados.entity.EmployeeEntity;
import com.upax.empleados.entity.GenderEntity;
import com.upax.empleados.entity.JobEntity;
import com.upax.empleados.entity.WorkedHoursEntity;
import com.upax.empleados.model.request.EmployeeByIdRequest;
import com.upax.empleados.model.request.EmployeeRequest;
import com.upax.empleados.model.request.WorkedHoursRequest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Constantes de rutas.
 *
 * @author Elmer LV
 * @enterprise UPAX
 * @since 20/01/22
 */

public class DatosConstant {

    public static final EmployeeRequest EXPLOREE_REQUEST = new EmployeeRequest(null, 1L, 1L, "Elmer",
            "Lopez", LocalDate.parse("1990-01-13"));

    public static final EmployeeRequest EXPLOREE_EDAD_REQUEST = new EmployeeRequest(null, 1L, 1L, "BRYAN",
            "RAMIREZ", LocalDate.parse("2011-05-15"));

    public static final WorkedHoursRequest EXPLOREE_WORKED_HOURS_REQUEST = new WorkedHoursRequest(null, 1L, 12L, LocalDate.parse("2022-02-02"));

    public static final WorkedHoursRequest EXPLOREE_WORKED_HOURS_FECHA_REQUEST = new WorkedHoursRequest(null, 1L, 12L, LocalDate.parse("2023-02-12"));

    public static final List<EmployeeEntity> EXPLOREES_ENTITIES = Arrays.asList(
            new EmployeeEntity(1L, new GenderEntity(1L, "Hombre"), new JobEntity(1L, "Gerente", 75000.0),
                    "Elmer", "Lopez", LocalDate.parse("1990-01-13")),
            new EmployeeEntity(2L, new GenderEntity(2L, "Mujer"), new JobEntity(1L, "Gerente", 75000.0),
                        "Roxana", "Kreimer", LocalDate.parse("1973-10-11"))
    );

    public static final EmployeeByIdRequest EXPLOREE_TOTAL_WORKED_HOURS_REQUEST = new EmployeeByIdRequest(1L, LocalDate.parse("2022-02-01"),LocalDate.parse("2022-02-12"));

    public static final EmployeeByIdRequest EXPLOREE_TOTAL_WORKED_HOURS_FECHA_REQUEST = new EmployeeByIdRequest(1L, LocalDate.parse("2022-02-11"),LocalDate.parse("2022-02-10"));

    public static final List<WorkedHoursEntity> EXPLOREES_ID_ENTITIES = Arrays.asList(
            new WorkedHoursEntity(1L,new EmployeeEntity(1L, new GenderEntity(1L, "Hombre"),
                    new JobEntity(1L, "Gerente", 75000.0), "Elmer", "Lopez", LocalDate.parse("1990-01-13")),
                    14,LocalDate.parse("2022-02-01"))
    );

    public static final Optional<EmployeeEntity> O_EXPLOREES_PAYMENT_ENTITY = Optional.of(
            new EmployeeEntity(1L, new GenderEntity(1L, "Hombre"), new JobEntity(1L, "Gerente", 467.50),
                    "Elmer", "Lopez", LocalDate.parse("1990-01-13"))
    );

}

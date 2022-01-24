package com.upax.empleados.constant;

import com.upax.empleados.entity.EmployeeEntity;
import com.upax.empleados.entity.GenderEntity;
import com.upax.empleados.entity.JobEntity;
import com.upax.empleados.model.request.EmployeeRequest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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

    public static final EmployeeRequest EXPLOREE_REQUEST_NULL = new EmployeeRequest(null, null, null, null,
            null, null);

    public static final List<EmployeeEntity> EXPLOREES_ENTITIES = Arrays.asList(
            new EmployeeEntity(1L, new GenderEntity(1L, "Hombre"), new JobEntity(1L, "Gerente", 75000.0),
                    "Elmer", "Lopez", LocalDate.parse("1990-01-13")),
            new EmployeeEntity(2L, new GenderEntity(2L, "Mujer"), new JobEntity(1L, "Gerente", 75000.0),
                        "Roxana", "Kreimer", LocalDate.parse("1973-10-11"))
    );

    public static final EmployeeEntity EXPLOREE_ENTITY = new EmployeeEntity(1L, new GenderEntity(1L, "Hombre"),
            new JobEntity(1L, "Gerente", 75000.0), "Elmer", "Lopez", LocalDate.parse("1990-01-13"));


}

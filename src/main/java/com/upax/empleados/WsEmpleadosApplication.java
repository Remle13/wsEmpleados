package com.upax.empleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class WsEmpleadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsEmpleadosApplication.class, args);
	}

}

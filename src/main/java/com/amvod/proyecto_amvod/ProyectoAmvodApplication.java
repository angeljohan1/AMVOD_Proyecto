package com.amvod.proyecto_amvod;

import com.amvod.proyecto_amvod.entity.Empleado;
import com.amvod.proyecto_amvod.entity.Empresa;
import com.amvod.proyecto_amvod.entity.MovimientoDinero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoAmvodApplication {

	//public static void main(String[] args) {
	//	SpringApplication.run(ProyectoAmvodApplication.class, args);
	//}

	public static void main(String[] args) {

		Empleado empleado = new Empleado("Angel Alcazar", "angel@gmail.com", "Empresa Prueba",
				"Administrador");
		Empresa empresa = new Empresa("808092789", "Empresa Prueba",
				"Calle 5 No. 89-78", "37898888" );
		MovimientoDinero movimiento = new MovimientoDinero(1500000,
				"Compra de herramientas", "Angel");

		System.out.println(empleado.toString());
		System.out.println(empresa.toString());
		System.out.println(movimiento.toString());


	}


}

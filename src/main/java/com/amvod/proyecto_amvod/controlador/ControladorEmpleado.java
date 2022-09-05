package com.amvod.proyecto_amvod.controlador;

import com.amvod.proyecto_amvod.entidades.Empleado;
import com.amvod.proyecto_amvod.servicios.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class ControladorEmpleado {

    @Autowired
    private ServicioEmpleado servicioEmpleado;

    //METODO PARA VER EMPLEADOS
    @GetMapping
    public List<Empleado> verEmpleados() {
        return servicioEmpleado.listarEmpleado();
    }

    //METODO PARA GUARDAR UN NUEVO EMPLEADO
    @PostMapping
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        return servicioEmpleado.guadarActualizarEmpleado(empleado);
    }

    //METODO PARA BUSCAR UN EMPLEADO POR ID
    @GetMapping("/{id}")
    public Empleado empleadoPorID(@PathVariable("id") Integer id) {
        return servicioEmpleado.consultarEmpleadoPorId(id);
    }

    //METODO ACTUALIZAR EMPLEADO BUSCADO POR ID
    @PatchMapping("/{id}")
    public Empleado actualizarEmpleado(@PathVariable("id") Integer idEmpleado, @RequestBody Empleado empleado) {
        Empleado emp = servicioEmpleado.consultarEmpleadoPorId(idEmpleado);
        emp.setNombreEmpleado(empleado.getNombreEmpleado());
        emp.setApellidoEmpleado(empleado.getApellidoEmpleado());
        emp.setEmail(empleado.getEmail());
        emp.setEmpresaEmpleado(empleado.getEmpresaEmpleado());
        emp.setRol(empleado.getRol());
        return servicioEmpleado.guadarActualizarEmpleado(emp);
    }

    //METODO PARA ELIMINAR UN REGISTRO EMPLEADO
    @DeleteMapping("/{id}")
    public String eliminarEmpleado(@PathVariable("id") Integer idEmpleado) {
        boolean respuesta = servicioEmpleado.eliminarEmpleado(idEmpleado);
        if (respuesta == true) {
            return "Se elimino el empleado por id:  " + idEmpleado;
        } else {
            return "No se pudo eliminar el empleado por id:  " + idEmpleado;
        }
    }
}
package com.amvod.proyecto_amvod.servicios;

import com.amvod.proyecto_amvod.entidades.Empleado;
import com.amvod.proyecto_amvod.repositorios.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEmpleado {

    @Autowired
    private RepositorioEmpleado repoEmpleado;

    //Metodo que muestra los empleados
    public List<Empleado> listarEmpleado() {
        return repoEmpleado.findAll();
    }

    //Metodo que guarda o actualiza un empleado
    public Empleado guadarActualizarEmpleado(Empleado empleado) {
        return repoEmpleado.save(empleado);
    }

    //Metodo que consulta un empleado por id
    public Empleado consultarEmpleadoPorId(Integer idEmpleado) {
        return repoEmpleado.findById(idEmpleado).get();
    }

    //Metodo que elimina un empleado por id
    public boolean eliminarEmpleado (Integer idEmpleado) {
        repoEmpleado.deleteById(idEmpleado);
        if (repoEmpleado.findById(idEmpleado)!=null) {
            return true;
        }
        return false;
    }
}

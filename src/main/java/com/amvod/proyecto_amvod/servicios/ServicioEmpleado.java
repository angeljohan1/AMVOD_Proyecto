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

    public List<Empleado> listarEmpleado() {
        return repoEmpleado.findAll();
    }

    public Empleado guadarActualizarEmpleado(Empleado empleado) {
        return repoEmpleado.save(empleado);
    }

    public Empleado consultarEmpleadoPorId(Integer idEmpleado) {
        return repoEmpleado.findById(idEmpleado).get();
    }

    public boolean eliminarEmpleado (Integer idEmpleado) {
        repoEmpleado.deleteById(idEmpleado);
        if (repoEmpleado.findById(idEmpleado)!=null) {
            return true;
        }
        return false;
    }
}

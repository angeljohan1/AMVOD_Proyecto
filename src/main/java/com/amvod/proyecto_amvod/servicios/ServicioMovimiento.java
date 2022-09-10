package com.amvod.proyecto_amvod.servicios;

import com.amvod.proyecto_amvod.entidades.MovimientoDinero;
import com.amvod.proyecto_amvod.repositorios.RepositorioMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioMovimiento {

    @Autowired
    private RepositorioMovimiento repoMovimiento;

    //metodo que retorna la lista de movimientos
    public List<MovimientoDinero> listarMovimiento() {
        return repoMovimiento.findAll();
    }

    //metodo que guarda o actualiza un movimiento
    public MovimientoDinero guadarActualizarMovimiento(MovimientoDinero movimiento) {
        return repoMovimiento.save(movimiento);
    }

    //metodo que consulta un movimiento por id
    public MovimientoDinero consultarMovimientoPorId(Integer idMovimiento) {
        return repoMovimiento.findById(idMovimiento).get();
    }

    //metodo que elimina un movimiento por id
    public boolean eliminarMovimiento (Integer idMovimiento) {
        repoMovimiento.deleteById(idMovimiento);
        if(repoMovimiento.findById(idMovimiento)!=null) {
            return true;
        }
        return false;
    }

    //Buscar movimientos por id del empleado
    public ArrayList<MovimientoDinero> buscarPorEmpleado(Integer id) {
        return repoMovimiento.buscarPorEmpleado(id);
    }

    //Buscar movimientos por id de la empresa a la que pertenecen los empleados
    public ArrayList<MovimientoDinero> buscarPorEmpresa(Integer id) {
        return repoMovimiento.buscarPorEmpresa(id);
    }

}
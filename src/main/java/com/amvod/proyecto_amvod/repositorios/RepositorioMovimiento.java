package com.amvod.proyecto_amvod.repositorios;

import com.amvod.proyecto_amvod.entidades.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositorioMovimiento extends JpaRepository<MovimientoDinero, Integer> {

    //Metodo para buscar movimientos por empleado
    @Query(value ="select * from movimientos where empleado_id= ?1", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> buscarPorEmpleado(Integer id);

    //Metodo para buscar movimientos por empresa
    @Query(value="select * from movimientos where empleado_id in (select id from empleado where empresa_id= ?1)", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> buscarPorEmpresa(Integer id);
}

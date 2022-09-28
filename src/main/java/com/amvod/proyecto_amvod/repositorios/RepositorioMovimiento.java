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
    @Query(value="select * from movimientos_dinero where id_empleado in (select id_empleado from empleados where id_empresa = ?1)", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> buscarPorEmpresa(Integer id);

    //Metodo para ver la suma de TODOS LOS MOVIMIENTOS
    @Query(value="SELECT SUM(monto_movimiento) from movimientos_dinero", nativeQuery = true)
    public abstract Double SumarMonto();

    //Metodo para ver la suma de los movimientos por empresa
    @Query(value="select sum(monto_movimiento) from movimientos_dinero where id_empleado in (select id_empleado from empleados where id_empresa= ?1)", nativeQuery = true)
    public abstract Double MontosPorEmpresa(Integer id); //Id de la empresa
}

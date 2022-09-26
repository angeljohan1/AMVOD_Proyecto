package com.amvod.proyecto_amvod.repositorios;

import com.amvod.proyecto_amvod.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado, Integer> {

    @Query(value="SELECT * FROM empleados where id_empresa= ?1", nativeQuery=true)
    public abstract ArrayList<Empleado> findByEmpresa(Integer id);
}

package com.amvod.proyecto_amvod.repositorios;

import com.amvod.proyecto_amvod.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado, Integer> {

}

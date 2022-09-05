package com.amvod.proyecto_amvod.repositorios;

import com.amvod.proyecto_amvod.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpresa extends JpaRepository<Empresa, Integer> {

}

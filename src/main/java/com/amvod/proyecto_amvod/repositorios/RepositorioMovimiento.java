package com.amvod.proyecto_amvod.repositorios;

import com.amvod.proyecto_amvod.entidades.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMovimiento extends JpaRepository<MovimientoDinero, Integer> {
}

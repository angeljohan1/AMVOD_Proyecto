package com.amvod.proyecto_amvod.repositorios;

import com.amvod.proyecto_amvod.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {

    Usuario findByEmail(String email);
}

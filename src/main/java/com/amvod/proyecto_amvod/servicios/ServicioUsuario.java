package com.amvod.proyecto_amvod.servicios;

import com.amvod.proyecto_amvod.entidades.Usuario;
import com.amvod.proyecto_amvod.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ServicioUsuario {

    @Autowired
    private RepositorioUsuario repoUsuario;

    public Usuario createUsuario(Usuario newUsuario) {
        return repoUsuario.save(newUsuario);
    }

    public Usuario findUserByEmail(String email) {
        return repoUsuario.findByEmail(email);
    }

    public Usuario getOrCreateUsuario(Map<String, Object> userData) {
        String email = (String) userData.get("email");

        Usuario usuario = findUserByEmail(email);

        if (usuario==null) {
            String nickname = (String) userData.get("nickname");
            String imagen = (String) userData.get("picture");
            String auth0Id = (String) userData.get("sub");

            Usuario newUsuario = new Usuario(nickname, email, imagen, auth0Id);
            return createUsuario(newUsuario);
        }
        System.out.println(usuario.getEmail());
        return usuario;
    }

}

package com.amvod.proyecto_amvod.servicios;

import com.amvod.proyecto_amvod.entidades.Empresa;
import com.amvod.proyecto_amvod.repositorios.RepositorioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEmpresa {

    @Autowired
    private RepositorioEmpresa repoEmpresa;

    //metodo que retorna la lista de empresas
    public List<Empresa> listarEmpresas() {
        return repoEmpresa.findAll();
    }

    //metodo que guarda o actualiza una empresa
    public Empresa guadarActualizarEmpresa(Empresa empresa) {
        return repoEmpresa.save(empresa);
    }

    //metodo que consulta una empresa por id
    public Empresa consultarEmpresaPorId(Integer idEmpresa) {
        return repoEmpresa.findById(idEmpresa).get();
    }

    //metodo que elimina una empresa por id
    public boolean eliminarEmpresa (Integer idEmpresa) {
        repoEmpresa.deleteById(idEmpresa);
        if (repoEmpresa.findById(idEmpresa)!=null) {
            return true;
        }
        return false;
    }

}

package com.amvod.proyecto_amvod.controlador;

import com.amvod.proyecto_amvod.entidades.Empresa;
import com.amvod.proyecto_amvod.servicios.ServicioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorEmpresa {

    @Autowired
    private ServicioEmpresa servicioEmpresa;

    //METODO PARA VER EMPRESAS
    @GetMapping("/empresas")
    public List<Empresa> verEmpresa() {
        return servicioEmpresa.listarEmpresas();
    }

    //METODO PARA GUARDAR UNA NUEVA EMPRESA
    @PostMapping("/empresas")
    public Empresa guardarEmpresa(@RequestBody Empresa empresa) {
        return servicioEmpresa.guadarActualizarEmpresa(empresa);
    }

    //METODO PARA BUSCAR UN EMPRESA POR ID
    @GetMapping("/empresas/{id}")
    public Empresa empresaPorID(@PathVariable("id") Integer id) {
        return servicioEmpresa.consultarEmpresaPorId(id);
    }

    //METODO ACTUALIZAR EMPRESA BUSCADO POR ID
    @PatchMapping("/empresas/{id}")
    public Empresa actualizarEmpresa(@PathVariable("id") Integer idEmpresa, @RequestBody Empresa empresa) {
        Empresa emp = servicioEmpresa.consultarEmpresaPorId(idEmpresa);
        emp.setNombreEmpresa(empresa.getNombreEmpresa());
        emp.setDireccionEmpresa(empresa.getDireccionEmpresa());
        emp.setTelefonoEmpresa(empresa.getTelefonoEmpresa());
        emp.setNit(empresa.getNit());
        return servicioEmpresa.guadarActualizarEmpresa(emp);
    }

    //METODO PARA ELIMINAR UNA EMPRESA
    @DeleteMapping("/empresas/{id}")
    public String eliminarEmpresa(@PathVariable("id") Integer idEmpresa) {
        boolean respuesta = servicioEmpresa.eliminarEmpresa(idEmpresa);
        if (respuesta == true) {
            return "Se elimino la empresa por id:  " + idEmpresa;
        } else {
            return "No se pudo eliminar la empresa por id:  " + idEmpresa;
        }
    }
}

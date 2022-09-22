package com.amvod.proyecto_amvod.controlador;


import com.amvod.proyecto_amvod.entidades.Empleado;
import com.amvod.proyecto_amvod.entidades.Empresa;
import com.amvod.proyecto_amvod.servicios.ServicioEmpleado;
import com.amvod.proyecto_amvod.servicios.ServicioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class webController {

    @Autowired
    private ServicioEmpleado servicioEmpleado;

    @Autowired
    private ServicioEmpresa servicioEmpresa;

    @GetMapping("/index")
    public String index() {
        return "index";
    }
    // ---------------------------------------ver lista de empleados
    @GetMapping("/empleadosweb")
    public String verEmpleados (Model model) {
        model.addAttribute("empleados", servicioEmpleado.listarEmpleado());
        return "empleadosweb";
    }
    // ---------------------------------------ver formulario agregar empleado
    @GetMapping("/agregar-empleado")
    public String agregarEmpleados () {
        return "agregar-empleado";
    }
    // ---------------------------------------ver formulario agregar empresa
    @GetMapping("/agregar-empresa")
    private String verRegistoNuevaEmpresa(Empresa empresa){
        return "agregar-empresa";
    }
    // ---------------------------------------ver formulario actualizar empresa
    @GetMapping("/actualizar-empresa/{id}")
    private String verEmpresaParaActualizar(@PathVariable Integer id, Model model){
        Empresa emp = servicioEmpresa.consultarEmpresaPorId(id);
        model.addAttribute("empresa", emp);
        return "actualizar-empresa";
    }

    // ---------------------------------------actualizar empresa
    @PostMapping("/actualizar-empresa")
    public String actualizarEmpresa(@ModelAttribute("empresa") Empresa empresa, RedirectAttributes redirectAttributes){
        if(servicioEmpresa.guadarActualizarEmpresa(empresa)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/empresasweb";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/actualizar-empresa/" + empresa.getIdEmpresa();

    }

    // ---------------------------------------ver lista de empresas
    @GetMapping ("/empresasweb")
    public String verEmpresas(Model model){
        model.addAttribute("empresas",servicioEmpresa.listarEmpresas());
        return "empresasweb";
    }

    // ---------------------------------------guardar nueva empresa
    @PostMapping("/agregar-empresa")
    public String guardarEmpresa(Empresa empresa, RedirectAttributes redirectAttributes){
        if(servicioEmpresa.guadarActualizarEmpresa(empresa)==true) {
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/empresasweb";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/agregar-empresa";
    }

    // ---------------------------------------eliminar empresa
    @GetMapping("/eliminarempresa/{id}")
    public String eliminarEmpresa(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (servicioEmpresa.eliminarEmpresa(id)==true){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/empresasweb";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/empresasweb";
    }

}

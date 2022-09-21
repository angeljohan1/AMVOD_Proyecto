package com.amvod.proyecto_amvod.controlador;


import com.amvod.proyecto_amvod.entidades.Empleado;
import com.amvod.proyecto_amvod.servicios.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class webController {

    @Autowired
    private ServicioEmpleado servicioEmpleado;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/empleadosweb")
    public String verEmpleados (Model model) {
        model.addAttribute("empleados", servicioEmpleado.listarEmpleado());
        return "empleadosweb";
    }

    @GetMapping("/agregar-empleado")
    public String agregarEmpleados () {
        return "agregar-empleado";
    }


}

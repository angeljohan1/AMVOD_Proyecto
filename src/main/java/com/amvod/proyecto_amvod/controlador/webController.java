package com.amvod.proyecto_amvod.controlador;

import com.amvod.proyecto_amvod.entidades.Empleado;
import com.amvod.proyecto_amvod.entidades.Empresa;
import com.amvod.proyecto_amvod.entidades.MovimientoDinero;
import com.amvod.proyecto_amvod.servicios.ServicioEmpleado;
import com.amvod.proyecto_amvod.servicios.ServicioEmpresa;
import com.amvod.proyecto_amvod.servicios.ServicioMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
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
    @Autowired
    private ServicioMovimiento servicioMovimiento;

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            System.out.println(principal.getClaims());
        }
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
    public String guardarEmpleado(Model model){
        Empleado emp= new Empleado();
        model.addAttribute("empleado",emp);
        List<Empresa> listaEmpresas = servicioEmpresa.listarEmpresas();
        model.addAttribute("empresas",listaEmpresas);
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

    // ---------------------------------------ver formulario agregar movimiento
    @GetMapping("/agregar-movimiento")
    public String guardarMovimiento(Model model){
        MovimientoDinero mov= new MovimientoDinero();
        model.addAttribute("movimiento",mov);
        List<Empleado> listaEmpleados = servicioEmpleado.listarEmpleado();
        model.addAttribute("empleados",listaEmpleados);
        return "agregar-movimiento";
    }

    // ---------------------------------------ver formulario actualizar empleado
    @GetMapping("/actualizar-empleado/{id}")
    private String verEmpleadoParaActualizar(@PathVariable Integer id, Model model){
        Empleado empl = servicioEmpleado.consultarEmpleadoPorId(id);
        model.addAttribute("empleado", empl);
        List<Empresa> listaEmpresa = servicioEmpresa.listarEmpresas();
        model.addAttribute("empresas",listaEmpresa);
        return "actualizar-empleado";
    }

    // ---------------------------------------ver formulario actualizar movimiento
    @GetMapping("/actualizar-movimiento/{id}")
    public String verMovimentoParaActualizar(Model model, @PathVariable Integer id){
        MovimientoDinero mov = servicioMovimiento.consultarMovimientoPorId(id);
        model.addAttribute("movimiento",mov);
        List<Empleado> listaEmpleados= servicioEmpleado.listarEmpleado();
        model.addAttribute("empleados",listaEmpleados);
        return "actualizar-movimiento";
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

    // ---------------------------------------actualizar empleado
    @PostMapping("/actualizar-empleado")
    public String actualizarEmpleado(@ModelAttribute("empleado") Empleado empleado, RedirectAttributes redirectAttributes){
        if(servicioEmpleado.guadarActualizarEmpleado(empleado)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/empleadosweb";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/actualizar-empleado/" + empleado.getIdEmpleado();

    }

    // ---------------------------------------actualizar movimiento
    @PostMapping("/actualizar-movimiento")
    public String actualizarMovimiento(@ModelAttribute("movimiento") MovimientoDinero movimiento, RedirectAttributes redirectAttributes){
        if(servicioMovimiento.guadarActualizarMovimiento(movimiento)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/movimientosweb";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/actualizar-movimiento/"+ movimiento.getId();

    }

    // ---------------------------------------ver lista de empresas
    @GetMapping ("/empresasweb")
    public String verEmpresas(Model model){
        model.addAttribute("empresas",servicioEmpresa.listarEmpresas());
        return "empresasweb";
    }

    // ---------------------------------------ver lista de movimientos
    @GetMapping ("/movimientosweb")
    public String verMovimientos(Model model){
        model.addAttribute("movimientos",servicioMovimiento.listarMovimiento());

        double sumaMonto= servicioMovimiento.obtenerSumaMontos();
        model.addAttribute("SumaMontos",sumaMonto);//Mandamos la suma de todos los montos a la plantilla

        return "movimientosweb";
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

    // ---------------------------------------guardar nuevo empleado
    @PostMapping("/agregar-empleado")
    public String guardarEmpleado(Empleado empleado){
        if(servicioEmpleado.guadarActualizarEmpleado(empleado)==true) {
            return "redirect:/empleadosweb";
        }
        return "redirect:/agregar-empleado";
    }

    // ---------------------------------------guardar nuevo movimiento
    @PostMapping("/agregar-movimiento")
    public String guardarMovimiento(MovimientoDinero mov, RedirectAttributes redirectAttributes){
        if(servicioMovimiento.guadarActualizarMovimiento(mov)){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/movimientosweb";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/agregar-movimiento";
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

    // ---------------------------------------eliminar empresa
    @GetMapping("/eliminarempleado/{id}")
    public String eliminarEmpleado(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (servicioEmpleado.eliminarEmpleado(id)==true){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/empleadosweb";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/empleadosweb";
    }

    // ---------------------------------------eliminar movimiento
    @GetMapping("/eliminarmovimiento/{id}")
    public String eliminarMovimiento(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (servicioMovimiento.eliminarMovimiento(id)==true){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/movimientosweb";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/movimientosweb";
    }

    // ---------------------------------------Ver empleados por empresa
    @GetMapping("/empresasweb/{id}/empleados")
    public String verEmpleadosPorEmpresa(@PathVariable("id") Integer id, Model model){
        List<Empleado> listaEmpleados = servicioEmpleado.obtenerPorEmpresa(id);
        model.addAttribute("empleados",listaEmpleados);
        return "empleadosweb";
    }

    // ---------------------------------------Ver movimientos por empresa
    @GetMapping("/empresasweb/{id}/movimientos")
    public String movimientosPorEmpresa(@PathVariable("id")Integer id, Model model){
        List<MovimientoDinero> movlist = servicioMovimiento.buscarPorEmpresa(id);
        model.addAttribute("movimientos",movlist);

        double sumaMonto=servicioMovimiento.MontosPorEmpresa(id);
        model.addAttribute("SumaMontos",sumaMonto);
        return "movimientosweb"; //Llamamos al HTML
    }


}

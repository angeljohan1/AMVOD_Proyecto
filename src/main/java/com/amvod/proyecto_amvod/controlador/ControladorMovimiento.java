package com.amvod.proyecto_amvod.controlador;

import com.amvod.proyecto_amvod.entidades.MovimientoDinero;
import com.amvod.proyecto_amvod.servicios.ServicioMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorMovimiento {

    @Autowired
    private ServicioMovimiento servicioMovimiento;

    //METODO PARA VER MOVIMIENTOS
    @GetMapping("/movimientos")
    public List<MovimientoDinero> verMovimientosDinero() {
        return servicioMovimiento.listarMovimiento();
    }

    //METODO PARA GUARDAR UN NUEVO MOVIMIENTO
    @PostMapping("/movimientos")
    public MovimientoDinero guardarMovimientos(@RequestBody MovimientoDinero movimientoDinero) {
        return servicioMovimiento.guadarActualizarMovimiento(movimientoDinero);
    }

    //METODO PARA BUSCAR UN MOVIMIENTO POR ID
    @GetMapping("/movimiento/{id}")
    public MovimientoDinero movimientoDineroPorID(@PathVariable("id") Integer id) {
        return servicioMovimiento.consultarMovimientoPorId(id);
    }

    //METODO PARA ELIMINAR UN MOVIMIENTO POR ID
    @PatchMapping("/movimientos/{id}")
    public MovimientoDinero actualizarMovimiento(@PathVariable("id") Integer id, @RequestBody MovimientoDinero movimiento){
        MovimientoDinero mov = servicioMovimiento.consultarMovimientoPorId(id);
        mov.setConceptoMov(movimiento.getConceptoMov());
        mov.setMontoMov(movimiento.getMontoMov());
        mov.setEmpleado(movimiento.getEmpleado());
        return servicioMovimiento.guadarActualizarMovimiento(mov);
    }

    //METODO PARA ACTUALIZAR UN MOVIMIENTO POR ID
    @DeleteMapping("/movimientos/{id}")
    public String eliminarMovimiento(@PathVariable("id") Integer id){
        boolean respuesta= servicioMovimiento.eliminarMovimiento(id);
        if (respuesta){
            return "Se elimino correctamente el movimiento con id " + id;
        }
        return "No se pudo eliminar el movimiento con id "+ id;
    }

    //METODO PARA BUSCAR MOVIMIENTOS POR EMPRESA
    @GetMapping("/empresas/{id}/movimientos")
    public ArrayList<MovimientoDinero> movimientosPorEmpresa(@PathVariable("id") Integer id){
        return servicioMovimiento.buscarPorEmpresa(id);
    }


}

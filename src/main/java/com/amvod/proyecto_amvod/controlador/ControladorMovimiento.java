package com.amvod.proyecto_amvod.controlador;

import com.amvod.proyecto_amvod.entidades.MovimientoDinero;
import com.amvod.proyecto_amvod.servicios.ServicioMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}

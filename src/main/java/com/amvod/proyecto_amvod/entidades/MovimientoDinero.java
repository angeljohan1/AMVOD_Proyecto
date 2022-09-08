package com.amvod.proyecto_amvod.entidades;

import javax.persistence.*;

@Entity
@Table(name = "movimientos_dinero")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "monto_movimiento", nullable = false)
    private double montoMov;
    @Column(name = "concepto", nullable = false)
    private String conceptoMov;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    public MovimientoDinero() {
    }

    public MovimientoDinero(int id, double montoMov, String conceptoMov, Empleado empleado) {
        this.id = id;
        this.montoMov = montoMov;
        this.conceptoMov = conceptoMov;
        this.empleado = empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontoMov() {
        return montoMov;
    }

    public void setMontoMov(double montoMov) {
        this.montoMov = montoMov;
    }

    public String getConceptoMov() {
        return conceptoMov;
    }

    public void setConceptoMov(String conceptoMov) {
        this.conceptoMov = conceptoMov;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}

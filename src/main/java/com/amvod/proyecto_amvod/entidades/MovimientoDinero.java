package com.amvod.proyecto_amvod.entidades;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "movimientos_dinero")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "monto_movimiento", nullable = false)
    private Double montoMov;
    @Column(name = "concepto", nullable = false)
    private String conceptoMov;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;


    public MovimientoDinero() {
    }

    public MovimientoDinero(int id, double montoMov, String conceptoMov, Empleado empleado, LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.montoMov = montoMov;
        this.conceptoMov = conceptoMov;
        this.empleado = empleado;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getMontoMov() {
        return montoMov;
    }

    public void setMontoMov(Double montoMov) {
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

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}

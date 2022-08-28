package com.amvod.proyecto_amvod.entity;

public class MovimientoDinero {

    private double montoMov;
    private String conceptoMov;
    private String empleadoMov;

    public MovimientoDinero(double montoMov, String conceptoMov, String empleadoMov) {
        this.montoMov = montoMov;
        this.conceptoMov = conceptoMov;
        this.empleadoMov = empleadoMov;
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

    public String getEmpleadoMov() {
        return empleadoMov;
    }

    public void setEmpleadoMov(String empleadoMov) {
        this.empleadoMov = empleadoMov;
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" +
                "montoMov=" + montoMov +
                ", conceptoMov='" + conceptoMov + '\'' +
                ", empleadoMov='" + empleadoMov + '\'' +
                '}';
    }
}

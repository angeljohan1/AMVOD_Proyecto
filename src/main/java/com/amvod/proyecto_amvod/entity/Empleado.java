package com.amvod.proyecto_amvod.entity;

public class Empleado {

    private String nombreEmpleado;
    private String email;
    private String empresaEmpleado;
    private String rol;
    private String idCedula;

    public Empleado(String nombreEmpleado, String email, String empresaEmpleado, String rol, String idCedula) {
        this.nombreEmpleado = nombreEmpleado;
        this.email = email;
        this.empresaEmpleado = empresaEmpleado;
        this.rol = rol;
        this.idCedula = idCedula;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresaEmpleado() {
        return empresaEmpleado;
    }

    public void setEmpresaEmpleado(String empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getIdCedula() {
        return idCedula;
    }

    public void setIdCedula(String idCedula) {
        this.idCedula = idCedula;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombreEmpleado='" + nombreEmpleado + '\'' +
                ", email='" + email + '\'' +
                ", empresaEmpleado='" + empresaEmpleado + '\'' +
                ", rol='" + rol + '\'' +
                ", idCedula='" + idCedula + '\'' +
                '}';
    }
}

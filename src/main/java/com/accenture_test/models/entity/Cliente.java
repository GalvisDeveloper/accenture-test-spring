package com.accenture_test.models.entity;


import java.util.ArrayList;

public class Cliente {

    public String cedula;
    public String direccion;

    public Cliente () {

    }

    public Cliente(String cedula, String direccion) {
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}



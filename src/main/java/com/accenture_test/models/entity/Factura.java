package com.accenture_test.models.entity;

import java.util.ArrayList;

public class Factura {

    private static Factura instance = null;
    private Cliente cliente;
    private ArrayList<Producto> products;
    private double subtotal;
    private double total;
    private final static double iva = 0.19;
    private final static double domicilio = 4000;

    private Factura () {
        this.cliente = new Cliente("12345", "carrera 11# 14-08");
        this.products = new ArrayList<>();
    }

    public static Factura getInstance() {
        if(instance == null){
            instance = new Factura();
        }
        return instance;
    }

    public Factura(Cliente cli, double subtotal, double total) {
        this.cliente = cli;
        this.products = new ArrayList<>();
        this.subtotal = subtotal;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }


    public ArrayList<Producto> getProducts() {
        return products;
    }


    public double getSubtotal() {
        return subtotal;
    }


    public double getTotal() {
        return total;
    }


    public double getIva() {
        return iva;
    }

    public double getDomicilio() {
        return domicilio;
    }

    public void agregarProducto (Producto prod) {
        products.add(prod);
    }

    public void calcularTotal(){
        int aux = 0;
        if(subtotal > 70000 && subtotal < 100000){
            aux += subtotal * iva;
            total = subtotal + aux + domicilio;
        } else if (subtotal > 100000) {
            aux += subtotal * iva;
            total = subtotal + aux ;
        }
    }

    public void subTotal(){
        int aux = 0;
        for(int i = 0; i < products.size(); i ++) {
            aux += products.get(i).getPrecio();
        }
        subtotal = aux;
    }
}
